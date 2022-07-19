package com.sunfusheng.dagger2.kotlin.scope

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import com.sunfusheng.dagger2.kotlin.MainActivity
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
@Module
class ContextModule(private val context: Context) {

    @Provides
    fun provideContext() = context
}

@Module
class AppModule {

    @Singleton
    @Provides
    fun providePackageManager(context: Context): PackageManager {
        return context.packageManager
    }

    @Singleton
    @Provides
    fun providePackageInfo(context: Context): PackageInfo {
        return context.packageManager.getPackageInfo(context.packageName, 0)
    }
}

@Singleton
@Component(modules = [ContextModule::class, AppModule::class])
interface AppComponent {

    fun injectMainActivity(mainActivity: MainActivity)
}