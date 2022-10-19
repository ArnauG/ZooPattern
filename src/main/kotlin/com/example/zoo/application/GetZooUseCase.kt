package com.example.zoo.application

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooImp
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooRepositoryReader
import com.example.zoo.domain.ZooRepositoryWriter

interface GetZooUseCase {
    fun get(id: Int): Zoo
}

class GetZooUseCaseImp(private val zooRepositoryReader: ZooRepositoryReader) : GetZooUseCase {
    override fun get(id: Int): Zoo =
        zooRepositoryReader.get(ZooIdentity(id))
}
