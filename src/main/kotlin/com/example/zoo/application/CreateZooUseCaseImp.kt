package com.example.zoo.application

import com.example.zoo.domain.ZooImp
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooIdentitySequencer
import com.example.zoo.domain.ZooName
import com.example.zoo.domain.ZooRepositoryWriter
import com.example.zoo.domain.ZooSurface
import com.example.zoo.infrastructure.controller.ZooPostRequest

interface CreateZooUseCase {
    fun create(zooPostRequest: ZooPostRequest): ZooImp
}

class CreateZooUseCaseImp(
    private val zooIdentitySequencer: ZooIdentitySequencer,
    private val zooRepositoryWriter: ZooRepositoryWriter<ZooImp>
) : CreateZooUseCase {
    override fun create(zooPostRequest: ZooPostRequest): ZooImp {
        val zoo = ZooImp(
            ZooIdentity(zooIdentitySequencer.getNext()),
            ZooName(zooPostRequest.name),
            ZooSurface(zooPostRequest.surface)
        )
        zooRepositoryWriter.save(zoo)
        return zoo
    }
}
