package com.example.zoo.application

import com.example.zoo.domain.*
import com.example.zoo.infrastructure.controller.ZonePostRequest

interface CreateZoneUseCase {
    fun save(zooId: Int, zonePostRequest: ZonePostRequest): Zone
}

class CreateZoneUseCaseImp(
    private val zoneRepository: ZoneRepository
): CreateZoneUseCase {
    override fun save(zooId: Int, zonePostRequest: ZonePostRequest): Zone {
        val zone = Zone(
            ZoneName(zonePostRequest.name),
            ZoneSurface(zonePostRequest.surface),
            ZoneType(zonePostRequest.type.MONKEY),
        )
        zoneRepository.save(zone)
        return zone
    }
}
