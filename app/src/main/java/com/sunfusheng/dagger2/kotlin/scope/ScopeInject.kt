package com.sunfusheng.dagger2.kotlin.scope

import dagger.Component
import dagger.Module
import dagger.Provides
import javax.inject.Inject
import javax.inject.Scope

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
class Man5 {

    @Inject
    lateinit var car5: Car5

    init {
        DaggerMan5Component.create().injectMan5(this)
    }
}

class Car5 {

}

@Scope
@MustBeDocumented
@Retention(AnnotationRetention.RUNTIME)
annotation class Car5Scope

@Module
class Car5Module {

    @Provides
    @Car5Scope
    fun provideCar5() = Car5()
}

@Component(modules = [Car5Module::class])
@Car5Scope
interface Man5Component {

    fun injectMan5(man5: Man5)
}