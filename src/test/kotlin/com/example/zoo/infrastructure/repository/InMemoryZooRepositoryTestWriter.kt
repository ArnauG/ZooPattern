package com.example.zoo.infrastructure.repository

import com.example.zoo.domain.ZooImp
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.helper.ZooHelper
import org.junit.jupiter.api.BeforeEach
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class InMemoryZooRepositoryTestWriter {
    private lateinit var repository: InMemoryZooImpRepository<ZooImp>
    private var zooMutableMap = mutableMapOf<ZooIdentity, ZooImp>()

    @BeforeEach
    internal fun setUp() {
        repository = InMemoryZooImpRepository(zooMutableMap)
    }

    @Test
    fun `it should save a Zoo`() {
        val aZoo = ZooHelper.getAZoo() as ZooImp
        repository.save(aZoo)
        assertEquals(aZoo, zooMutableMap[aZoo.identity()])
    }

    @Test
    fun `it should get a Zoo`() {
        val aZoo = ZooHelper.getAZoo() as ZooImp
        repository.save(aZoo)
        var zoo = repository.get(aZoo.identity())
        assertEquals(aZoo, zoo)
    }

    @Test
    fun `it should return an exception when a zoo is not found`() {
        assertFailsWith<ResourceNotFoundException> { repository.get(ZooIdentity(0)) }
    }
}
