package com.dutch.coroutines20

import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking

fun main() = runBlocking {
    println("fetching data")

    val result = fetchData()
    println("result: $result")
}

private suspend fun fetchData() : String{
    delay(1000)
    return "s"
}
