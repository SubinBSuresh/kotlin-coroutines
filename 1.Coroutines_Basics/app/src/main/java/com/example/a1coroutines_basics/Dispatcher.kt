package com.example.a1coroutines_basics

import kotlinx.coroutines.*

fun main(){
    runBlocking {
        launch(Dispatchers.Unconfined) {
            println("Unconfined dispatcher. Thread:${Thread.currentThread().name}")
            delay(100L)
            println("Main dispatcher. Thread:${Thread.currentThread().name}")
        }

        launch(Dispatchers.Default){
            println("Default dispatcher. Thread:${Thread.currentThread().name}")
        }

        launch(Dispatchers.IO) {
            println("IO dispatcher. Thread:${Thread.currentThread().name}")

        }

        launch(newSingleThreadContext("MyContext")) {
            println("newSingleThreadContext dispatcher. Thread:${Thread.currentThread().name}")

        }
    }
}