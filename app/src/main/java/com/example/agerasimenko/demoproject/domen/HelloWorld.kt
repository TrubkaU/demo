package com.example.agerasimenko.demoproject.domen

const val HELLO_WORLD = "Hello world"

object HelloWorld {

    fun getHelloWorld() = HELLO_WORLD

    fun getIntHelloWorld() = HELLO_WORLD.first().toInt()
}