package com.dutch.coroutines20

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job: Job = launch {
        println("coroutine started in ${Thread.currentThread().name}")

        delay(1000)
        println("coroutine completed")
    }


    println("waiting for coroutine to complete")
//    waits for coroutine to complete
    job.join()

    println("done")

}