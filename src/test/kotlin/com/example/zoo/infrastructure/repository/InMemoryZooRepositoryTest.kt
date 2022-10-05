package com.example.zoo.infrastructure.repository

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.helper.ZooHelper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class InMemoryZooRepositoryTest {
    private lateinit var repository : InMemoryZooRepository
    private var zooMutableMap = mutableMapOf<Int, Zoo>()

    @BeforeEach
    internal fun setUp() {
        repository = InMemoryZooRepository(zooMutableMap)
    }

    @Test
    fun `it should save a Zoo`() {
        val aZoo = ZooHelper.getAZoo()
        repository.save(aZoo)
        assertEquals(aZoo, zooMutableMap[aZoo.id.id])
    }

    @Test
    fun `it should get a Zoo`() {
        val aZoo = ZooHelper.getAZoo()
        repository.save(aZoo)
        var zoo = repository.get(aZoo.id)
        assertEquals(aZoo, zoo)
    }

    @Test
    fun `it should return an exception when a zoo is not found`() {
        assertFailsWith<ResourceNotFoundException> { repository.get(ZooIdentity(0)) }
    }
}