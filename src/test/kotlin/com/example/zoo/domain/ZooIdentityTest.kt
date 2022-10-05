package com.example.zoo.domain

import org.junit.jupiter.api.Test
import kotlin.test.assertEquals

internal class ZooIdentityTest{
    @Test
    fun `it should overload toString method`(){
        assertEquals(ZooIdentity(1).toString(),"1")
    }
}