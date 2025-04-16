package com.dutch.coroutines20

import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main() = runBlocking {
    try {

        withTimeout(1500) {
            repeat(5) { i ->
                println("working $i")
                delay(500)
            }
        }
    } catch (e: TimeoutCancellationException) {
        println(e)
    }
}