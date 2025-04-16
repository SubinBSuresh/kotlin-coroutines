package com.dutch.coroutines20

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    val job: Job = launch {
        println("coroutine started in ${Thread.currentThread().name}")

        delay(2000)
        println("coroutine done")
    }

    println("waiting for coroutine to complete")

    println("is job active: ${job.isActive}")
    println("is job completed: ${job.isCompleted}")

    delay(1000)
    job.cancel()
    println("is job active: ${job.isActive}")
    println("is job completed: ${job.isCompleted}")
    println("is job cancelled: ${job.isCancelled}")


    job.join()
    println("done")

}