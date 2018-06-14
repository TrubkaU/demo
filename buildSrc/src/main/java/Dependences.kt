package com.example.agerasimenko.demoproject


object PluginDependences {
    const val android = "com.android.tools.build:gradle:${Versions.gradleAndroidPlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
    const val googleService = "com.google.gms:google-services:${Versions.googleService}"
}

object ProjectDependences {
    const val applicationId = "com.example.agerasimenko.demoproject"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompatV7 = "com.android.support:appcompat-v7:${Versions.appCompatV7}"
    const val junit = "junit:junit:${Versions.junit}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val firestore = "com.google.firebase:firebase-firestore:${Versions.firestore}"
}


object Versions {
    const val googleService = "3.2.0"
    const val gradleAndroidPlugin = "3.1.3"
    const val kotlin = "1.2.41"
    const val minSdk = 15
    const val targetSdk =  27
    const val code = 1
    const val name = "1.0"
    const val compileSdk = 27
    const val appCompatV7 = "27.1.1"
    const val junit = "4.12"
    const val dagger = "2.15"
    const val firestore = "17.0.1"
}