package com.example.zoo.domain

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

internal class ZooSurfaceTest {
    @Test
    fun `it should instance a ZooSurface`() {
        val surfaceM2 = 10000
        var zooSurface = ZooSurface(surfaceM2)
        assertEquals(zooSurface.surfaceM2, surfaceM2)
    }

    @Test
    fun `it should fail for surfaces higher than 10000`() {
        val surfaceM2 = 10001
        assertFailsWith<ZooMaxSurfaceException> { ZooSurface(surfaceM2) }
    }

    @Test
    fun `it should fail for surfaces equal or lower than 0`() {
        val surfaceM2 = 0
        assertFailsWith<ZooMinSurfaceException> { ZooSurface(surfaceM2) }
    }

    @Test
    fun `it should overload toString method`() {
        val surfaceM2 = 10000
        var zooSurface = ZooSurface(surfaceM2)
        assertEquals(zooSurface.toString(), "$surfaceM2 m^2")
    }
}
