package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.runBlocking

fun main()  = runBlocking {
    val strings = listOf("a","b","c")

    strings.asFlow().collect { v ->
        println(v)
        delay(2000)
    }
}