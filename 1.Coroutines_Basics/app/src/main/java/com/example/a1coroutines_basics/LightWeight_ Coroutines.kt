package com.example.a1coroutines_basics

import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main() {
    //runBlocking is also a coroutine builder that bridges the non-coroutine world of a
    // regular fun main() and the code with coroutines inside of runBlocking { ... } curly braces.
    // This is highlighted in an IDE by this: CoroutineScope hint right after the runBlocking
    // opening curly brace.
    runBlocking {
        repeat(100000) {
            launch {
                print("'-'")
            }
        }
    }
}