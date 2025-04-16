package com.dutch.coroutines20

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..7).asFlow().map { it * 2 }.collect { v ->
        println(v)
    }
}