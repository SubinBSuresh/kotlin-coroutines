package com.dutch.coroutines20

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking


fun main() = runBlocking {
     println("Main starts in ${Thread.currentThread().name}")

    val deffered = async {
        println("async launced on ${Thread.currentThread().name}")
        delay(1000)
        println("async done")
    }

    println("Doing something while async runs")

    val result = deffered.await()
    println("got async result: $result")

    println("Main thread ends on ${Thread.currentThread().name}")
}