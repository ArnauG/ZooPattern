package com.example.zoo.integration

import com.example.zoo.ZooApplication
import io.restassured.RestAssured
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
abstract class ResourceNotFoundExceptionTestCase {
    @Value("http://localhost:\${local.server.port}")
    private lateinit var localUri: String

    @Test
    fun `it should fail saving save a zoo with a out of range surface`() {
        val id = 6666
        RestAssured.given()
            .baseUri(localUri)
            .`when`()
            .get("/zoo/$id")
            .then()
            .assertThat()
            .statusCode(HttpStatus.NOT_FOUND.value())
            .body("statusCode", Matchers.equalTo(404))
            .body("message", Matchers.equalTo("Zoo $id not found"))
    }
}
