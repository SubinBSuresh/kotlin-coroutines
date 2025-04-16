package com.dutch.coroutines20

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..8).asFlow().flatMapConcat { flowOf(it * 2, it *3) }.collect { v -> println(v) }
}