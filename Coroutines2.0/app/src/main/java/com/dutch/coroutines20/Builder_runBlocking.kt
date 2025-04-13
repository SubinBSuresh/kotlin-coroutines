package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("runblocking starts on ${Thread.currentThread().name}")

    launch {
        println("Launch inside runblocking")
        delay(1000)
        println("coroutine done")
    }

    println("waiting for coroutine")

    delay(1500)
    println("runblocking ends")
}