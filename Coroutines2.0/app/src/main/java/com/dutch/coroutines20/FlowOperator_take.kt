package com.dutch.coroutines20

import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.take
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..8).asFlow().take(3).collect { v-> println(v) }
}