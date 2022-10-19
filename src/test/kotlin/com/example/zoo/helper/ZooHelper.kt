package com.example.zoo.helper

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.Zone
import com.example.zoo.domain.ZoneName
import com.example.zoo.domain.ZoneSurface
import com.example.zoo.domain.ZoneType
import com.example.zoo.domain.ZooImp
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooName
import com.example.zoo.domain.ZooSurface

const val ZOO_NAME = "zoo Name"
const val ZOO_SURFACE = 10000

private const val ZONE_NAME = "Zone Name"


private const val ZONE_SURFACE = 10

class ZooHelper {
    companion object {
        fun getAZoo() : Zoo = ZooImp(ZooIdentity(1), ZooName(ZOO_NAME), ZooSurface(ZOO_SURFACE))
        fun getAZone() = Zone(ZoneName(ZONE_NAME), ZoneSurface(ZONE_SURFACE), ZoneType.MONKEY)
    }
}
