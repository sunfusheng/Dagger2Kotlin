package com.sunfusheng.dagger2.kotlin.mvp_with_dagger2

import dagger.Component

/**
 * @author by sunfusheng on 2019/2/7
 */
@Component(modules = [RepoModule::class])
interface RepoComponent {
    fun inject(fragment: RepoFragment)
}