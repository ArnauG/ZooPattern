package com.example.zoo.infrastructure.controller

import com.example.zoo.application.CreateZooUseCase
import com.example.zoo.application.GetZooUseCase
import com.example.zoo.domain.ZooImp
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooName
import com.example.zoo.domain.ZooSurface
import org.junit.jupiter.api.Test
import org.mockito.kotlin.whenever
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest
import org.springframework.boot.test.mock.mockito.MockBean
import org.springframework.http.HttpHeaders
import org.springframework.http.MediaType
import org.springframework.test.web.servlet.MockMvc
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders
import org.springframework.test.web.servlet.result.MockMvcResultMatchers

@WebMvcTest(controllers = [ZooController::class])
class ZooControllerTest {

    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var createZooUseCase: CreateZooUseCase
    @MockBean
    private lateinit var getZooUseCase: GetZooUseCase

    @Test
    fun `it should create a zoo`() {
        val zooName = "zoo name"
        val surface = 10000

        val givenZooRequest = ZooPostRequest(zooName, surface)
        whenever(createZooUseCase.create(givenZooRequest))
            .thenReturn(ZooImp(ZooIdentity(1), ZooName(zooName), ZooSurface(surface)))

        val expectedResponse = "{\"id\":\"1\", \"name\":\"$zooName\", \"surface\":\"$surface m^2\"}"
        mvc.perform(
            MockMvcRequestBuilders.post("/zoo")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                    """
          {
            "name": "$zooName",
            "surface": $surface
          }
                    """.trimIndent()
                )
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.header().string(HttpHeaders.CONTENT_TYPE, "application/json")
            )
            .andExpect(MockMvcResultMatchers.content().json(expectedResponse))
    }

    @Test
    fun `it should get a zoo`() {
        val zooName = "zoo name"
        val surface = 10000
        val id = 1
        whenever(getZooUseCase.get(id))
            .thenReturn(ZooImp(ZooIdentity(id), ZooName(zooName), ZooSurface(surface)))

        val expectedResponse = "{\"id\":\"1\", \"name\":\"$zooName\", \"surface\":\"$surface m^2\"}"
        mvc.perform(
            MockMvcRequestBuilders.get("/zoo/$id")
        )
            .andExpect(MockMvcResultMatchers.status().isOk)
            .andExpect(
                MockMvcResultMatchers.header().string(HttpHeaders.CONTENT_TYPE, "application/json")
            )
            .andExpect(MockMvcResultMatchers.content().json(expectedResponse))
    }
}
