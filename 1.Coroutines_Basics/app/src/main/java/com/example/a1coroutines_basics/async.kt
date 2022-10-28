package com.example.a1coroutines_basics

import kotlinx.coroutines.async
import kotlinx.coroutines.delay
import kotlinx.coroutines.runBlocking
import java.util.*
import kotlin.random.Random.Default.nextInt

fun main(){
    runBlocking {
        val firstDeferred = async{
            getFirstValue()
        }
        val secondDeferred = async {
            getSecondValue()
        }
        println("Doing some processing here")
        delay(200L)
        println("Waiting for values")

        val firstValue = firstDeferred.await()
        val secondValue = secondDeferred.await()
        println("The total is ${firstValue + secondValue}")
    }
}

suspend fun getFirstValue(): Int{
    delay(100L)
//    val value: Random.Default = Random.nextInt(100)
    val value = 100
    println("Returning first valu $value")
    return value
}


suspend fun getSecondValue(): Int{
    delay(200L)
//    val value: Random.Default = Random.nextInt(200)
    val value = 200

    println("Returning first valu $value")
    return value
}