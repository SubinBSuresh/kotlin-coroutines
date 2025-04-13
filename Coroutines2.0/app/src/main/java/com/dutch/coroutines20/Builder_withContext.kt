package com.dutch.coroutines20

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() = runBlocking {
    println("Main starts in ${Thread.currentThread().name}")

    val result = withContext(Dispatchers.Unconfined) {
        println("running on ${Thread.currentThread().name}")
        delay(1000)
        "Result from IO context"
    }

    println("got result: $result")
    println("main ends on ${Thread.currentThread().name}")
}