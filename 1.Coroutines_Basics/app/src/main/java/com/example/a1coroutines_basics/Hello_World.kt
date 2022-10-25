package com.example.a1coroutines_basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch


fun main(){
    // launch - coroutine builder
    // launches a new coroutine concurrently with the rest of the code, which continues to work independently
    GlobalScope.launch {

        //delay -  is a special suspending function.
        // It suspends the coroutine for a specific time.
        // Suspending a coroutine does not block the underlying thread,
        // but allows other coroutines to run and use the underlying thread for their code.
        delay(1000)
        println("Hello ")
    }

    println("Hello")
    Thread.sleep(2000)
}