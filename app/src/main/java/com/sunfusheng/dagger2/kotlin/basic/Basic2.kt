package com.sunfusheng.dagger2.kotlin.basic

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
class Man2() {

    @Inject
    lateinit var car2: Car2

    init {
        DaggerMan2Component.create().injectMan2(this)
    }

    override fun toString() = "Man2(car2=$car2)"
}

class Car2 {

    override fun toString() = "Car2"
}

@Module
class Car2Module {

    @Provides
    fun provideCar2() = Car2()
}

@Component(modules = [Car2Module::class])
interface Man2Component {

    fun injectMan2(man2: Man2)
}