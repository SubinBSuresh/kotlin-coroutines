package com.dutch.coroutines20

import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {

    val parentJob: Job = launch {
        println("coroutine started in ${Thread.currentThread().name}")

        val childJob1: Job = launch {
            println("child job started in ${Thread.currentThread().name}")
            delay(1000)
            println("childjob1 done")
        }

        val childJob2: Job = launch {
            println("child job 2 started in ${Thread.currentThread().name}")
            delay(2000)
            println("child job 2 completed")
        }

        childJob1.join()
        childJob2.join()
        println("parent job done")
    }


    delay(1500)
    println("cancelling parent job")


    parentJob.cancel()
    parentJob.join()

    println("done")
}