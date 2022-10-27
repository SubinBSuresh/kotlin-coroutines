package com.example.a1coroutines_basics

import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
    runBlocking {
        val job1 = launch {
//            delay(3000L)
            println("Job 1 launched")

            val job2 = launch {
                println("Job 2 launched")
                delay(300L)
                println("Job 2 is finishing")
            }
            job2.invokeOnCompletion {
                print("Job 2 is finished ")
            }
            val job3 = launch {
                println("Job 3 launched")
                delay(300L)
                println("Job 3 is finishing")
            }
            job3.invokeOnCompletion {
                print("Job 3 is finished ")
            }
        }
        delay(500L)
        job1.invokeOnCompletion {
            println("Job 1 is completed")
        }
        println("Job 1 will be cancelled")
        job1.cancel()
    }
}