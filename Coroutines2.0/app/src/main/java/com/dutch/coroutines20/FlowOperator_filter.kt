package com.dutch.coroutines20

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..7).asFlow().filter { it % 2 == 0 }.collect { v -> println(v) }
}