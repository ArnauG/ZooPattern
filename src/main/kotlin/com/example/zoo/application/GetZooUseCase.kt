package com.example.zoo.application

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooRepository

interface GetZooUseCase {
    fun get(id: Int): Zoo
}

class GetZooUseCaseImp(private val zooRepository: ZooRepository) : GetZooUseCase {
    override fun get(id: Int): Zoo =
        zooRepository.get(ZooIdentity(id))
}
