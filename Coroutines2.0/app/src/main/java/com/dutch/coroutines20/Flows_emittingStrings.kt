package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking

private fun stringFlow(): Flow<String> = flow {
    emit("apple")
    delay(500)
    emit("grapes")
    delay(500)
    emit("apple")
    delay(500)
    emit("grapes")
    delay(500)
    emit("apple")
    delay(500)
    emit("grapes")
    delay(500)

}

fun main() = runBlocking {
    stringFlow().collect { values ->
        println("values: $values")
    }
}