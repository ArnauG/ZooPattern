package com.example.zoo.domain

data class Zone(val zoneId: ZoneId, val name: ZoneName, val surface: ZoneSurface, val type: ZoneType)

enum class ZoneType {
    MONKEY,
    LION,
    ELEPHANT
}

data class ZoneId(val id: String)
data class ZoneName(val name: String) {
    override fun toString(): String {
        return name
    }
}
data class ZoneSurface(val value: Int)
