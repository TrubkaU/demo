package com.example.agerasimenko.demoproject.domen

import org.junit.Test

import org.junit.Assert.*

class HelloWorldTest {

    @Test
    fun getHelloWorld() {

        assertEquals(HELLO_WORLD, HelloWorld.getHelloWorld())
    }

    @Test
    fun getIntHelloWorld() {
        assertEquals(72, HelloWorld.getIntHelloWorld())
    }
}