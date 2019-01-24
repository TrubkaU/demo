package com.example.agerasimenko.demoproject.domen

const val HELLO_WORLD = "Hello world"

object KotlinClass {

    fun getHelloWorld() = HELLO_WORLD

    fun getIntHelloWorld() = HELLO_WORLD.first().toInt()
}