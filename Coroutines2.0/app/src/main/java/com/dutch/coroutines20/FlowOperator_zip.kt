package com.dutch.coroutines20

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.flow.zip
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val flow1 = flowOf(1,2,3,4,5)
    val flow2 = flowOf("s","u", "b", "i", "n")

    flow1.zip(flow2) {a,b ->"$a$b"}.collect { v-> println(v) }
}