package com.example.zoo.infrastructure.controller

import com.example.zoo.application.CreateZooUseCase
import com.example.zoo.application.GetZooUseCase
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController

@RestController
class ZooController(
    private val createZooUseCase: CreateZooUseCase,
    private val getZooUseCase: GetZooUseCase
) {

    @PostMapping(
        value = ["/zoo"],
        consumes = ["application/json"],
        produces = ["application/json"]
    )
    fun createZoo(
        @RequestBody zooPostRequest: ZooPostRequest
    ): ResponseEntity<ZooPostResponse> {
        var zoo = createZooUseCase.create(zooPostRequest)
        return ResponseEntity.ok(ZooPostResponse(zoo.id.toString(), zoo.name.toString(), zoo.surface.toString()))
    }

    @GetMapping(
        value = ["/zoo/{id}"],
        produces = ["application/json"]
    )
    fun getZoo(
        @PathVariable id: Int
    ): ResponseEntity<ZooGetResponse> {
        var zoo = getZooUseCase.get(id)
        return ResponseEntity.ok(ZooGetResponse(zoo.identity().toString(), zoo.name().toString(), zoo.surface().toString()))
    }
}

data class ZooPostRequest(val name: String, val surface: Int)
data class ZooPostResponse(val id: String, val name: String, val surface: String)
data class ZooGetResponse(val id: String, val name: String, val surface: String)
