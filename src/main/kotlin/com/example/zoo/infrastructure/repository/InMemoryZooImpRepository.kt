package com.example.zoo.infrastructure.repository

import com.example.zoo.domain.Zone
import com.example.zoo.domain.ZoneName
import com.example.zoo.domain.ZoneRepository
import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooRepositoryReader
import com.example.zoo.domain.ZooRepositoryWriter

class InMemoryZooImpRepository<T : Zoo>(private var zooMutableMap: MutableMap<ZooIdentity, T>)
    : ZooRepositoryWriter<T>, ZooRepositoryReader, ZoneRepository {

    override fun save(zoo: T) {
        zooMutableMap[zoo.identity()] = zoo
    }

    override fun get(identity: ZooIdentity): Zoo {
        return zooMutableMap[identity] ?: throw ResourceNotFoundException("Zoo ${identity.id} not found")
    }

    override fun save(zooIdentity: ZooIdentity, zone: Zone) {
        TODO("Not yet implemented")
    }

    override fun get(zooIdentity: ZooIdentity, zoneName: ZoneName) {
        TODO("Not yet implemented")
    }
}

class ResourceNotFoundException(s: String) : RuntimeException(s)
