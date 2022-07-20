package com.sunfusheng.dagger2.kotlin.component

import android.content.Context
import android.content.pm.ApplicationInfo
import android.content.pm.PackageInfo
import com.sunfusheng.dagger2.kotlin.MainActivity
import dagger.*
import javax.inject.Scope
import javax.inject.Singleton

/**
 * @author sunfusheng
 * @since  2022/07/20
 */
@Singleton
@Component(modules = [AppModule::class])
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun context(context: Context): Builder

        fun build(): AppComponent
    }

    fun applicationInfoComponent(): ApplicationInfoComponent.Builder
}

@Module(subcomponents = [ApplicationInfoComponent::class])
class AppModule {

    @Singleton
    @Provides
    fun providePackageInfo(context: Context): PackageInfo {
        return context.packageManager.getPackageInfo(context.packageName, 0)
    }
}

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class AppInfoScope

@AppInfoScope
@Subcomponent(modules = [ApplicationInfoModule::class])
interface ApplicationInfoComponent {

    @Subcomponent.Builder
    interface Builder {
        fun build(): ApplicationInfoComponent
    }

    fun injectMainActivity(mainActivity: MainActivity)
}

@Module
class ApplicationInfoModule {

    @AppInfoScope
    @Provides
    fun provideApplicationInfo(context: Context): ApplicationInfo {
        return context.packageManager.getApplicationInfo(context.packageName, 0)
    }
}