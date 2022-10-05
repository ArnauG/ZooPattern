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
abstract class DomainExceptionTestCase {
    @Value("http://localhost:\${local.server.port}")
    private lateinit var localUri: String

    @Test
    fun `it should fail saving save a zoo with a out of range surface`() {
        var zooName = "zoo name"
        var surface = 100000
        val maxSurface = 10000
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
            .statusCode(HttpStatus.BAD_REQUEST.value())
            .body("statusCode", Matchers.equalTo(400))
            .body("message", Matchers.equalTo("Max surface allowed $maxSurface, actual value $surface"))
    }
}