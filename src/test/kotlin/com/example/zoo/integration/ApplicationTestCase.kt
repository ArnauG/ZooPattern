package com.example.zoo.integration

import com.example.zoo.ZooApplication
import org.junit.jupiter.api.Test
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest(
    classes = [ZooApplication::class]
)
@AutoConfigureMockMvc
abstract class ApplicationTestCase {
    @Test
    fun contextLoads() {
    }
}
