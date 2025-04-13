package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("Main starts on ${Thread.currentThread().name}")

    val job = launch {
        println("Launched on ${Thread.currentThread().name}")
        delay(1000)
        println("Launch block one")
    }

    println("Doing something else while coroutine runs")

//    job.join()

    println("Main ends on ${Thread.currentThread().name}")
}