package com.sunfusheng.dagger2.kotlin.section2

import kotlinx.coroutines.*

/**
 * @author sunfusheng on 2019/1/31.
 */
class UserPresenter {
    private var mView: IUserView? = null
    private var mJob: Job? = null


    fun attachView(view: IUserView) {
        this.mView = view
    }

    fun detachView() {
        this.mView = null
        this.mJob?.cancel()
    }

    fun getMsg() {
        mJob = GlobalScope.launch(Dispatchers.Main) {
            val user = fetchUserAsync().await()
            mView?.showUser(user)
        }
    }

    private suspend fun fetchUserAsync() = GlobalScope.async(Dispatchers.Default) {
        delay(3000)
        User("sunfusheng")
    }
}