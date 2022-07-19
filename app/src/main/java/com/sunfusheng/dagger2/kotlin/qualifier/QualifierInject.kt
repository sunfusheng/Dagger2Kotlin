package com.sunfusheng.dagger2.kotlin.qualifier

import android.util.Log
import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Qualifier

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
class Man4 {

    @Named("car41")
    @Inject
    lateinit var car41: Car4

    @Car42
    @Inject
    lateinit var car42: Car4

    init {
        DaggerMan4Component.create().injectMan4(this)
    }

    fun goWork() {
        car41.go("work")
    }

    fun goHome() {
        car42.go("home")
    }
}

class Car4 @Inject constructor() {

    fun go(where: String) {
        Log.d("Car4", "[sfs] $this go $where")
    }
}

@Qualifier
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Car42

@Module
class Car4Module {

    @Named("car41")
    @Provides
    fun provideCar41() = Car4()

    @Car42
    @Provides
    fun provideCar42() = Car4()
}

@Component(modules = [Car4Module::class])
interface Man4Component {

    fun injectMan4(man4: Man4)
}
