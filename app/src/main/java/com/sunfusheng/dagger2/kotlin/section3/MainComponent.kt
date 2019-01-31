package com.sunfusheng.github.kotlin

import com.sunfusheng.dagger2.kotlin.MainActivity
import dagger.Component

/**
 * @author by sunfusheng on 2019/1/28
 */
@Component(modules = [UserModule::class, RepoModule::class])
interface MainComponent {
    fun inject(activity: MainActivity)
}