package com.example.zoo.domain

interface ZooIdentitySequencer {
    fun getNext() : Int
}