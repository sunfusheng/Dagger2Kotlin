package com.sunfusheng.dagger2.kotlin

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sunfusheng.dagger2.kotlin.basic.Man1
import com.sunfusheng.dagger2.kotlin.basic.Man2

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        basic()
    }

    private fun basic() {
        Log.d(TAG, Man1().toString())
        Log.d(TAG, Man2().toString())
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}


