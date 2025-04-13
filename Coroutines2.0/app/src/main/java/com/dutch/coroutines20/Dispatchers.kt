package com.dutch.coroutines20

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    launch(Dispatchers.Main) {
        println("runs on ${Thread.currentThread().name}")
    }

    launch(Dispatchers.IO) {
        println("runs on ${Thread.currentThread().name}")
        delay(1000)
    }

    launch(Dispatchers.Default) {
        println("runs on ${Thread.currentThread().name}")
        delay(500)
    }

    delay(1500)
}