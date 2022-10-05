package com.example.zoo.domain

interface ZooRepository {
    fun save(zoo: Zoo)
    fun get(identity: ZooIdentity): Zoo
}
