package com.sunfusheng.dagger2.kotlin

import android.app.Application
import com.sunfusheng.dagger2.kotlin.scope.AppComponent
import com.sunfusheng.dagger2.kotlin.scope.AppModule
import com.sunfusheng.dagger2.kotlin.scope.ContextModule
import com.sunfusheng.dagger2.kotlin.scope.DaggerAppComponent

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
class MainApplication : Application() {

    lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .contextModule(ContextModule(this))
            .appModule(AppModule())
            .build()
    }
}