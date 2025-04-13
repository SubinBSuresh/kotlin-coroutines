package com.dutch.coroutines20

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

fun main()  {
    GlobalScope.launch {
        println("Global scope launched")
        delay(1000)
        println("Global scope done")
    }

    Thread.sleep(1500)
}