package com.example.zoo.domain

data class Zoo(val id: ZooIdentity, val name: ZooName, val surface: ZooSurface)

data class ZooIdentity(val id: Int) {
    override fun toString() = "$id"
}

data class ZooName(private val name: String) {
    override fun toString() = name
}

private const val MAX_SURFACE = 10000
private const val MIN_SURFACE = 0

data class ZooSurface(val surfaceM2: Int) {

    init {
        if (surfaceM2 > MAX_SURFACE) throw ZooMaxSurfaceException(MAX_SURFACE, surfaceM2)
        if (surfaceM2 <= MIN_SURFACE) throw ZooMinSurfaceException(MIN_SURFACE, surfaceM2)
    }

    override fun toString() = "$surfaceM2 m^2"
}


