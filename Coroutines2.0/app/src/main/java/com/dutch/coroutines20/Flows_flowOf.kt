package com.dutch.coroutines20

import kotlinx.coroutines.flow.flowOf
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    flowOf("a","b").collect { v->
        println(v)
    }
}