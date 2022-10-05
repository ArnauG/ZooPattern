package com.example.zoo.application

import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooRepository
import com.example.zoo.helper.ZooHelper
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
internal class GetZooUseCaseImpTest {
    @Mock
    private lateinit var zooRepository: ZooRepository

    @Test
    fun `should return a Zoo`() {
        val id = 1
        whenever(zooRepository.get(ZooIdentity(id))).thenReturn(ZooHelper.getAZoo())
        var getZooUseCaseImp = GetZooUseCaseImp(zooRepository)
        var zoo = getZooUseCaseImp.get(id)
        assertEquals(ZooHelper.getAZoo(), zoo)
    }
}
