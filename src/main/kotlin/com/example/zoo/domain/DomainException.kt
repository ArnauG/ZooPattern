package com.example.zoo.domain

sealed class DomainException(message: String) : RuntimeException(message)

class ZooMaxSurfaceException(private val maxSurface: Int, private val surface: Int) :
    DomainException("Max surface allowed $maxSurface, actual value $surface")

class ZooMinSurfaceException(private val minSurface: Int, private val surface: Int) :
    DomainException("Min surface allowed $minSurface, actual value $surface")
