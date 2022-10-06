package com.example.zoo.domain

data class Zone(val name: ZoneName, val surface: ZoneSurface, val type: ZoneType)

enum class ZoneType {
    MONKEY,
    LION,
    ELEPHANT
}

data class ZoneName(val name: String) {
    override fun toString(): String {
        return name
    }
}
data class ZoneSurface(val value: Int)
