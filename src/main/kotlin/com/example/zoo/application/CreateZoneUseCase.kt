package com.example.zoo.application

import com.example.zoo.domain.*
import com.example.zoo.infrastructure.controller.ZonePostRequest

interface CreateZoneUseCase {
    fun save(zooId: Int, zonePostRequest: ZonePostRequest): Zone
}

class CreateZoneUseCaseImp(
    private val zoneRepository: ZoneRepository,
    private val zooRepositoryReader: ZooRepositoryReader
) : CreateZoneUseCase {
    override fun save(zooId: Int, zonePostRequest: ZonePostRequest): Zone {
        val zooIdentity = ZooIdentity(zooId)
        var zoo = zooRepositoryReader.get(zooIdentity)
        val zone = zoo.addZone(Zone(
            ZoneName(zonePostRequest.name),
            ZoneSurface(zonePostRequest.surface),
            ZoneType.valueOf(zonePostRequest.type.uppercase()),
        ))
        zoneRepository.save(zoo.identity(), zone)
        return zone
    }
}
