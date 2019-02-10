package com.sunfusheng.dagger2.kotlin.mvp_without_dagger2

import kotlinx.coroutines.*

/**
 * @author sunfusheng on 2019/1/31.
 */
class UserPresenter(private val mView: IUserView) {
    private var mJob: Job? = null

    fun detachView() {
        this.mJob?.cancel()
    }

    fun fetchUser() {
        mJob = GlobalScope.launch(Dispatchers.Main) {
            val user = async {
                delay(3000)
                User("sunfusheng")
            }.await()
            mView.onUserCallback(user)
        }
    }
}