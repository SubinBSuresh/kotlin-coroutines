package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private fun countdownFlow(): Flow<Int> = flow {
    for (i in 5 downTo 1) {
        emit(i)
        delay(1000)
    }
}

fun main() = runBlocking {
    println("starting coroutine in ${Thread.currentThread().name}")
    countdownFlow().collect { value ->
        println("value: $value")
    }

    println("done")

}