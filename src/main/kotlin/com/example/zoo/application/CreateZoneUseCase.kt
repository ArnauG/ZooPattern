package com.example.zoo.application

import com.example.zoo.domain.Zone
import com.example.zoo.infrastructure.controller.ZonePostRequest

interface CreateZoneUseCase {
    fun save(zooId: Int, zonePostRequest: ZonePostRequest): Zone
}
