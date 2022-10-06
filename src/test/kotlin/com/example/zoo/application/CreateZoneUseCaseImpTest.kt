package com.example.zoo.application

import com.example.zoo.domain.*
import com.example.zoo.infrastructure.controller.ZonePostRequest
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.Mock
import org.mockito.junit.jupiter.MockitoExtension
import org.mockito.kotlin.any
import org.mockito.kotlin.whenever
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class)
class CreateZoneUseCaseImpTest {

    @Mock
    private lateinit var zoneRepository: ZoneRepository

    @Test
    fun `it should create a Zone`() {
        val zoneName = "zoo name"
        val surface = 10000
        val type = "MONKEY"
        val zooId = 1
        val givenAZoneRequest = ZonePostRequest(zoneName, surface, type)
        val expectedZone = Zone(ZoneName(zoneName), ZoneSurface(surface), ZoneType.MONKEY)
        whenever(zoneRepository.save(any()))

        var createZoneUseCaseImp = CreateZoneUseCaseImp(zoneRepository)

        var zone = createZoneUseCaseImp.save(zooId, givenAZoneRequest)

        assertEquals(expectedZone, zone)
    }
}