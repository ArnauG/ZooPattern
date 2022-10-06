package com.example.zoo.infrastructure.controller

import com.example.zoo.application.CreateZoneUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ZoneController(private val createZoneUseCase: CreateZoneUseCase) {

    @PostMapping(
        value = ["/zoo/{id}/zone"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun createZone(
        @PathVariable("id") zooId: Int,
        @RequestBody zonePostRequest: ZonePostRequest
    ): ResponseEntity<ZonePostResponse> {
        var zone = createZoneUseCase.save(zooId, zonePostRequest)
        return ResponseEntity.ok(ZonePostResponse(zone.name.toString(), zone.surface.value, zone.type.name))
    }
}

data class ZonePostRequest(val name: String, val surface: Int, val type: String)
data class ZonePostResponse(val name: String, val surface: Int, val type: String)
