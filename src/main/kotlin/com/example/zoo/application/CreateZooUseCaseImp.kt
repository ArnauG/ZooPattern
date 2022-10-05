package com.example.zoo.application

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooIdentitySequencer
import com.example.zoo.domain.ZooName
import com.example.zoo.domain.ZooRepository
import com.example.zoo.domain.ZooSurface
import com.example.zoo.infrastructure.controller.ZooPostRequest

interface CreateZooUseCase {
    fun create(zooPostRequest: ZooPostRequest): Zoo
}

class CreateZooUseCaseImp(
    private val zooIdentitySequencer: ZooIdentitySequencer,
    private val zooRepository: ZooRepository
) : CreateZooUseCase {
    override fun create(zooPostRequest: ZooPostRequest): Zoo {
        val zoo = Zoo(
                ZooIdentity(zooIdentitySequencer.getNext()),
                ZooName(zooPostRequest.name),
                ZooSurface(zooPostRequest.surface)
            )
        zooRepository.save(zoo)
        return zoo
    }
}


