package com.example.zoo.domain

interface ZooRepositoryWriter<T : Zoo> {
    fun save(zoo: T)
}

interface ZooRepositoryReader {
    fun get(identity: ZooIdentity): Zoo

}
