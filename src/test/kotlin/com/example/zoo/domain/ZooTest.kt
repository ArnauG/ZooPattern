package com.example.zoo.domain

import com.example.zoo.helper.ZooHelper
import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ZooTest(){
    @Test
    fun `it should add a zone`(){
        var aZone = ZooHelper.getAZone()
        var aZoo = ZooHelper.getAZoo()
        var addedZone = aZoo.addZone(aZone)
        assertEquals(aZone,addedZone)
    }
}