package com.example.zoo.domain

interface ZoneRepository {
    fun save(zooIdentity: ZooIdentity, zone: Zone)
    fun get(zooIdentity: ZooIdentity, zoneName: ZoneName)
}
