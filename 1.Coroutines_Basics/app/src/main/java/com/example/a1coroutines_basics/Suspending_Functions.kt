package com.example.a1coroutines_basics

import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

var functionCalls:Int = 0

fun main(){

    GlobalScope.launch {
        completeMessage()
    }

    GlobalScope.launch {
        improveMessage()
    }

    print("Hello")
    Thread.sleep(2000L)
    println("Function calls $functionCalls")

}

suspend fun completeMessage(){
    delay(50L)
    println("World")
    functionCalls++
}

suspend fun improveMessage(){
    delay(1000L)
    println("Functions are neat")
    functionCalls++
}