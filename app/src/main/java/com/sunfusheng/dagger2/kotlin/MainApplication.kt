package com.sunfusheng.dagger2.kotlin

import android.app.Application
import com.sunfusheng.dagger2.kotlin.component.AppComponent
import com.sunfusheng.dagger2.kotlin.component.ApplicationInfoComponent
import com.sunfusheng.dagger2.kotlin.component.DaggerAppComponent

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
class MainApplication : Application() {

    lateinit var appComponent: AppComponent
    lateinit var applicationInfoComponent: ApplicationInfoComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()
            .context(this)
            .build()

        applicationInfoComponent = appComponent.applicationInfoComponent().build()
    }
}