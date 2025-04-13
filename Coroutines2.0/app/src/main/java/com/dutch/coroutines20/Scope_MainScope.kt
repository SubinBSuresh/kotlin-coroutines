package com.dutch.coroutines20

import kotlinx.coroutines.MainScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main() {
    val scope = MainScope()

    scope.launch {
        println("Mainscope started in ${Thread.currentThread().name}")

        delay(1000)

        println("mainscope couroutine completed")
    }


    Thread.sleep(1600)
}