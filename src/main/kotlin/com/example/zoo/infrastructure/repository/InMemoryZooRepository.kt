package com.example.zoo.infrastructure.repository

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooRepository

class InMemoryZooRepository(private var zooMutableMap: MutableMap<ZooIdentity, Zoo>) : ZooRepository {

    override fun save(zoo: Zoo) {
        zooMutableMap[zoo.id] = zoo
    }

    override fun get(identity: ZooIdentity): Zoo {
        return zooMutableMap[identity] ?: throw ResourceNotFoundException("Zoo ${identity.id} not found")
    }
}

class ResourceNotFoundException(s: String) : RuntimeException(s)
