package com.example.zoo.application

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooIdentitySequencer
import com.example.zoo.domain.ZooName
import com.example.zoo.domain.ZooRepository
import com.example.zoo.domain.ZooSurface
import com.example.zoo.infrastructure.controller.ZooPostRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
internal class CreateZooUseCaseImpTest {

    @Mock
    private lateinit var zooRepository: ZooRepository

    @Mock
    private lateinit var zooIdentitySequencer: ZooIdentitySequencer

    @Test
    fun `it should create a Zoo`() {
        val surface = 10000
        val name = "zoo name"
        val givenAZooRequest = ZooPostRequest(name, surface)
        val expectedZoo = Zoo(ZooIdentity(1), ZooName(name), ZooSurface(surface))
        whenever(zooIdentitySequencer.getNext()).thenReturn(1)
        doNothing().`when`(zooRepository).save(any())

        var createZooUseCaseImp = CreateZooUseCaseImp(zooIdentitySequencer, zooRepository)

        var zoo = createZooUseCaseImp.create(givenAZooRequest)

        assertEquals(expectedZoo, zoo)
    }
}