package com.example.zoo.helper

import com.example.zoo.domain.Zoo
import com.example.zoo.domain.ZooIdentity
import com.example.zoo.domain.ZooName
import com.example.zoo.domain.ZooSurface

const val ZOO_NAME = "zoo Name"
const val ZOO_SURFACE = 10000

class ZooHelper {
    companion object {
        fun getAZoo() = Zoo(ZooIdentity(1), ZooName(ZOO_NAME), ZooSurface(ZOO_SURFACE))
    }
}
