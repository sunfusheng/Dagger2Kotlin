package com.sunfusheng.dagger2.kotlin.mvp_with_dagger2

import dagger.Module
import dagger.Provides

/**
 * @author by sunfusheng on 2019/2/7
 */
@Module
class RepoModule(val mView: IRepoView) {

    @Provides
    fun provideRepoPresenter(): RepoPresenter = RepoPresenter(mView)

    @Provides
    fun provideRepoView(): IRepoView = mView
}