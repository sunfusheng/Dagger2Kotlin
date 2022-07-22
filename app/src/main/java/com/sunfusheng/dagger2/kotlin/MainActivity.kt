package com.sunfusheng.dagger2.kotlin

import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.sunfusheng.dagger2.kotlin.basic.Man1
import com.sunfusheng.dagger2.kotlin.basic.Man2
import com.sunfusheng.dagger2.kotlin.lazy.Man3
import com.sunfusheng.dagger2.kotlin.qualifier.Man4
import dagger.Lazy
import javax.inject.Inject

class MainActivity() : AppCompatActivity() {

    @Inject
    lateinit var mPackageInfo: Lazy<PackageInfo>

    @Inject
    lateinit var mApplicationInfo: Lazy<ApplicationInfo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        basicInject()
        lazyInject()
        qualifierInject()
        componentInject()
    }

    private fun basicInject() {
        Log.d(TAG, "[sfs] ${Man1().toString()}")
        Log.d(TAG, "[sfs] ${Man2().toString()}")
    }

    private fun lazyInject() {
        Man3().goWork()
        Man3().goHome()
    }

    private fun qualifierInject() {
        Man4().goWork()
        Man4().goHome()
    }

    private fun componentInject() {
        (application as MainApplication).applicationInfoComponent.inject(this)

        val pi = mPackageInfo.get()
        Log.d(TAG, "[sfs] $pi versionName: ${pi.versionName}")

        val ai = mApplicationInfo.get()
        Log.d(TAG, "[sfs] $ai targetSdkVersion: ${ai.targetSdkVersion}")
    }

    companion object {
        private const val TAG = "MainActivity"
    }
}


