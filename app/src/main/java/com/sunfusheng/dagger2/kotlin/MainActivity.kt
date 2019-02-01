package com.sunfusheng.dagger2.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.coroutines.*
import kotlin.system.measureTimeMillis

class MainActivity : AppCompatActivity() {

    @ObsoleteCoroutinesApi
    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    fun testCoroutine() {
        GlobalScope.launch {
            val time = measureTimeMillis {
                val x = doSomethingAsync1()
                val y = doSomethingAsync2()
                Log.d("--->", "x + y = ${x + y}")
            }
            Log.d("--->", "$time ms")
        }.invokeOnCompletion {

        }
    }

    suspend fun doSomethingAsync1() = coroutineScope {
        delay(1000)
        1
    }

    suspend fun doSomethingAsync2() = coroutineScope {
        delay(1000)
        1
    }


}


