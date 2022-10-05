package com.example.zoo

import com.example.zoo.integration.ApplicationTestCase
import com.example.zoo.integration.DomainExceptionTestCase
import com.example.zoo.integration.ResourceNotFoundExceptionTestCase
import com.example.zoo.integration.SaveZooTestCase
import org.junit.jupiter.api.AfterAll
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Nested
import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest

class ZooApplicationTests {
	@Nested
	internal inner class Application : ApplicationTestCase()

	@Nested
	internal inner class SaveZoo : SaveZooTestCase()

	@Nested
	internal inner class DomainException : DomainExceptionTestCase()

	@Nested
	internal inner class ResourceNotFoundException : ResourceNotFoundExceptionTestCase()


}
