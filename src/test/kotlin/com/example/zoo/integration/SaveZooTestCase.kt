package com.example.zoo.integration

import com.example.zoo.ZooApplication
import io.restassured.RestAssured
import io.restassured.http.ContentType
import org.hamcrest.Matchers
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.http.HttpStatus

@SpringBootTest(
    classes = [ZooApplication::class],
    webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT
)
@AutoConfigureMockMvc
abstract class SaveZooTestCase {

    @Value("http://localhost:\${local.server.port}")
    private lateinit var localUri: String

    @Test
    fun `should save a zoo`() {
        var zooName = "zoo name"
        var surface = 10000
        RestAssured.given()
            .baseUri(localUri)
            .contentType(ContentType.JSON)
            .body(
                """
                {
                    "name": "$zooName",
                    "surface": $surface
                }
                """.trimIndent()
            )
            .`when`()
            .post("/zoo/")
            .then()
            .assertThat()
            .statusCode(HttpStatus.OK.value())
            .body("name", Matchers.equalTo("$zooName"))
            .body("surface", Matchers.equalTo("$surface m^2"))
    }
}
