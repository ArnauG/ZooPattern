package com.example.zoo.infrastructure.repository

import com.example.zoo.domain.ZooIdentitySequencer

class InMemoryZooIdentitySequencer : ZooIdentitySequencer {
    private var actualSequenceNumber: Int = 1
    override fun getNext(): Int = actualSequenceNumber++
}
