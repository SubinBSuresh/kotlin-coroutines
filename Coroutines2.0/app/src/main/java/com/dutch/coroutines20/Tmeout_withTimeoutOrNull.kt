package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeoutOrNull


fun main() = runBlocking {
    val result = withTimeoutOrNull(1500) {
        repeat(5) { i ->
            println("working $i")
            delay(500)

        }
        println("done")
    }

    println("result $result")
}