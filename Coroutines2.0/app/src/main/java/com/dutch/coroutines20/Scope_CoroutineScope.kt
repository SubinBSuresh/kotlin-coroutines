package com.dutch.coroutines20

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val customScope = CoroutineScope(Dispatchers.Default + Job())

    customScope.launch {
        println("custom scope coroutine started on ${Thread.currentThread().name}")
        delay(1000)
        println("custom scope coroutine done")
    }


    Thread.sleep(1500)
}