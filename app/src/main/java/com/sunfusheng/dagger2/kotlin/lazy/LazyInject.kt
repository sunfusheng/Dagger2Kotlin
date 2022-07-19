package com.sunfusheng.dagger2.kotlin.lazy

import android.util.Log
import dagger.Component
import dagger.Lazy
import javax.inject.Inject
import javax.inject.Provider

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
class Man3 {

    @Inject
    lateinit var lazyCar: Lazy<Car3>

    @Inject
    lateinit var providerCar: Provider<Car3>

    init {
        DaggerMan3Component.create().injectMan3(this)
    }

    fun goWork() {
        lazyCar.get().go("work")
        lazyCar.get().go("work")
    }

    fun goHome() {
        providerCar.get().go("home")
        providerCar.get().go("home")
    }
}

class Car3 @Inject constructor() {

    fun go(where: String) {
        Log.d("Car3", "[sfs] $this go $where")
    }
}

@Component
interface Man3Component {

    fun injectMan3(man3: Man3)
}
