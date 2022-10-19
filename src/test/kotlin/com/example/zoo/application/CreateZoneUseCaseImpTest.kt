package com.example.zoo.application

import com.example.zoo.domain.*
import com.example.zoo.helper.ZooHelper
import com.example.zoo.infrastructure.controller.ZonePostRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.doNothing
import org.mockito.kotlin.eq
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class CreateZoneUseCaseImpTest {

    @Mock
    private lateinit var zoneRepository: ZoneRepository

    @Mock
    private lateinit var zooRepositoryReader: ZooRepositoryReader

    @Test
    fun `it should create a Zone`() {
        val zoneName = "zoo name"
        val surface = 10000
        val type = "MONKEY"
        val zooId = ZooIdentity(1)
        val givenAZoneRequest = ZonePostRequest(zoneName, surface, type)
        val expectedZone = Zone(ZoneName(zoneName), ZoneSurface(surface), ZoneType.MONKEY)
        doNothing().`when`(zoneRepository).save(eq(zooId), any())
        var aZoo = ZooHelper.getAZoo()
        whenever(zooRepositoryReader.get(eq(zooId))).thenReturn(aZoo)

        var createZoneUseCaseImp = CreateZoneUseCaseImp(zoneRepository, zooRepositoryReader)

        var zone = createZoneUseCaseImp.save(zooId.id, givenAZoneRequest)

        assertEquals(expectedZone, zone)
    }
}