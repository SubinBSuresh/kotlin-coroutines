package com.dutch.coroutines20

import kotlinx.coroutines.*

fun main() = runBlocking {
    println("Hello from ${Thread.currentThread().name}")

    launch {
        delay(1000)
        println("Coroutine finished!")
    }

    println("Waiting...")
    delay(1500)
}
