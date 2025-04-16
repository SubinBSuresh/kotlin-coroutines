package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    (1..8).asFlow().onEach { delay(500) }.collectLatest { v-> println(v) }
}