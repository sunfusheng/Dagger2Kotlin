package com.sunfusheng.dagger2.kotlin.section2

/**
 * @author sunfusheng on 2019/1/31.
 */
class MessagePresenter {
    var msgView: IMsgView? = null

    fun attachView(view: IMsgView) {
        this.msgView = view
    }

    fun detachView() {
        this.msgView = null
    }

    fun getMsg() {

    }
}