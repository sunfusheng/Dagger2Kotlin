package com.sunfusheng.dagger2.kotlin.section2

/**
 * @author sunfusheng on 2019/1/31.
 */
interface IView<P : IPresenter> {
    fun setPresenter(P: IPresenter)
    fun onAttach()
    fun onDetach()
}