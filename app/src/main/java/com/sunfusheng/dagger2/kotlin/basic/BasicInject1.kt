package com.sunfusheng.dagger2.kotlin.basic

import dagger.Component
import javax.inject.Inject

/**
 * @author sunfusheng
 * @since  2022/07/19
 */
class Man1 {

    @Inject
    lateinit var car1: Car1

    init {
        DaggerMan1Component.create().injectMan1(this)
    }

    override fun toString() = "Man1(car1=$car1)"
}

class Car1 @Inject constructor() {

}

@Component
interface Man1Component {

    fun injectMan1(man1: Man1)
}