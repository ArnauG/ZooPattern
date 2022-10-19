package com.example.zoo.domain

interface Zoo {
    fun addZone(zone: Zone): Zone
    fun identity(): ZooIdentity
    fun name(): ZooName
    fun surface(): ZooSurface
}

data class ZooImp(val id: ZooIdentity, val name: ZooName, val surface: ZooSurface) : Zoo {
    private var zones = HashMap<ZoneName, Zone>()
    override fun addZone(zone: Zone): Zone {
        return zone
    }

    override fun identity(): ZooIdentity = id

    override fun name() = name

    override fun surface() = surface
}

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
