package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.runBlocking

private fun callbackFlowExample(): Flow<Int> = callbackFlow {
    for (i in 1..8) {
        delay(500)
        trySend(i).isSuccess
    }
    close()
}

fun main() = runBlocking {
    callbackFlowExample().collect { v ->
        println(v)
    }
}