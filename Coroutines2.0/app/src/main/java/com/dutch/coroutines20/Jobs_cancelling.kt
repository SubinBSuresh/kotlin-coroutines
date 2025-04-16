package com.dutch.coroutines20

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job: Job = launch {
        println("coroutine started in ${Thread.currentThread().name}")

        for (i in 1..5){
            println("working $i")
            delay(1000)
        }

        println("coroutine done")
    }

    delay(2000)

    println("cancelling job")

    job.cancel()

    job.join()
    println("done")

}