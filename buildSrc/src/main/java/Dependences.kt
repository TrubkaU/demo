package com.example.agerasimenko.demoproject


object PluginDependences {
    const val android = "com.android.tools.build:gradle:${Versions.gradleAndroidPlugin}"
    const val kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.kotlin}"
}


object ProjectDependences {
    const val applicationId = "com.example.agerasimenko.demoproject"
    const val kotlin = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
    const val appCompatV7 = "com.android.support:appcompat-v7:${Versions.appCompatV7}"
    const val constrainLayout = "com.android.support.constraint:constraint-layout:${Versions.constrain}"
    const val junit = "junit:junit:${Versions.junit}"
    const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.dagger}"
    const val dagger = "com.google.dagger:dagger:${Versions.dagger}"
    const val stetho = "com.facebook.stetho:stetho-okhttp:${Versions.stetho}"
    const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroid}"
}


object Versions {
    const val gradleAndroidPlugin = "3.1.3"
    const val kotlin = "1.2.41"
    const val minSdk = 15
    const val targetSdk =  27
    const val code = 1
    const val name = "1.0"
    const val compileSdk = 27
    const val appCompatV7 = "27.1.1"
    const val constrain = "1.1.1"
    const val junit = "4.12"
    const val dagger = "2.15"
    const val stetho = "1.5.0"
    const val rxAndroid = "2.0.2"
}