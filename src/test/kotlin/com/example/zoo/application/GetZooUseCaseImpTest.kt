package com.example.zoo.application

import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooRepositoryReader
import com.example.zoo.domain.ZooRepositoryWriter
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
    private lateinit var zooRepositoryReader : ZooRepositoryReader

    @Test
    fun `should return a Zoo`() {
        val id = 1
        whenever(zooRepositoryReader.get(ZooIdentity(id))).thenReturn(ZooHelper.getAZoo())
        var getZooUseCaseImp = GetZooUseCaseImp(zooRepositoryReader)
        var zoo = getZooUseCaseImp.get(id)
        assertEquals(ZooHelper.getAZoo(), zoo)
    }
}
