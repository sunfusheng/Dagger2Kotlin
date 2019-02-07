package com.sunfusheng.dagger2.kotlin

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import kotlinx.coroutines.ExperimentalCoroutinesApi

class MainActivity : AppCompatActivity() {

    @ExperimentalCoroutinesApi
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loop@ for (i in 1..100) {
            for (j in 1..100) {
                if (i == 10 && j == 10) {
                    Log.d("--->", "i=$i, j=$j")
                    break@loop
                }
            }
            Log.d("--->", "i=$i")
        }

        apply {
            val a = parent
            return
        }
    }


}


