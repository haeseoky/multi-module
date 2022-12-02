package com.multimodule.api.controller.simple

import kotlinx.coroutines.*
import org.junit.jupiter.api.Test
import java.time.ZonedDateTime
import java.time.temporal.ChronoUnit


class Coroutine {

    fun now() = ZonedDateTime.now().toLocalDateTime().truncatedTo((ChronoUnit.MILLIS))
    fun log(msg: String) = println("${now()} : ${Thread.currentThread()} : $msg")

    fun launchInGlobalScope() {
        GlobalScope.launch {
            log("launchInGlobalScope")
            Thread.sleep(2000)
            log("launchInGlobalScope done")
        }
    }

    fun runBlockingExample(){
        log("runBlockingExample")
        runBlocking {

            val async1 = async {
                log("async1")
                delay(2000)
                log("async1 done")
            }
            val async2 = async {
                log("async2")
                delay(3000)
                log("async2 done")
            }

            log("runBlockingExample")
            delay(6000)
            log("runBlockingExample done")

            async1.await()
            log("async1 done")
            async2.await()
            log("async2 done")


        }
        log("runBlockingExample done")
    }
    @Test
    fun main() {
        log("main() started")
        runBlockingExample()
//        Thread.sleep(5000)
        log("main() finished")
    }
}