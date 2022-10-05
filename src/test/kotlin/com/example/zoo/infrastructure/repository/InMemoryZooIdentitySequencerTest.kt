package com.example.zoo.infrastructure.repository

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class InMemoryZooIdentitySequencerTest {
    @Test
    fun `it should generate a new sequence on start`() {
        var sequencer = InMemoryZooIdentitySequencer()
        assertEquals(1, sequencer.getNext())
    }

    @Test
    fun `it should get next sequence number`() {
        var sequencer = InMemoryZooIdentitySequencer()
        sequencer.getNext()
        assertEquals(2, sequencer.getNext())
    }
}
