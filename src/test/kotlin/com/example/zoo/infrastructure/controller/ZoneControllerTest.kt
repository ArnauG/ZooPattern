package com.example.zoo.infrastructure.controller

import com.example.zoo.application.CreateZoneUseCase
import com.example.zoo.domain.Zone
import com.example.zoo.domain.ZoneId
import com.example.zoo.domain.ZoneName
import com.example.zoo.domain.ZoneSurface
import com.example.zoo.domain.ZoneType
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

@WebMvcTest(controllers = [ZoneController::class])
internal class ZoneControllerTest {
    @Autowired
    private lateinit var mvc: MockMvc

    @MockBean
    private lateinit var createZoneUseCase: CreateZoneUseCase

    @Test
    fun `it should create a zone`() {
        val zoneName = "zoo name"
        val surface = 10000
        val type = "MONKEY"
        val zooId = 1

        val givenZoneRequest = ZonePostRequest(zoneName, surface, type)

        whenever(createZoneUseCase.save(zooId, givenZoneRequest))
            .thenReturn(Zone(ZoneId(zoneName), ZoneName(zoneName), ZoneSurface(surface), ZoneType.MONKEY))
        val expectedResponse = "{\"name\":\"$zoneName\", \"surface\":$surface, \"type\":\"MONKEY\"}"
        mvc.perform(
            MockMvcRequestBuilders.post("/zoo/$zooId/zone")
                .contentType(MediaType.APPLICATION_JSON_VALUE)
                .content(
                    """
                  {
                    "name": "$zoneName",
                    "surface": $surface,
                    "type": "$type"
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
}
