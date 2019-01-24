package com.example.agerasimenko.demoproject.domen

import org.junit.Test

import org.junit.Assert.*

class KotlinClassTest {

    @Test
    fun getHelloWorld() {

        assertEquals(HELLO_WORLD, KotlinClass.getHelloWorld())
    }

    @Test
    fun getIntHelloWorld() {
        assertEquals(72, KotlinClass.getIntHelloWorld())
    }
}