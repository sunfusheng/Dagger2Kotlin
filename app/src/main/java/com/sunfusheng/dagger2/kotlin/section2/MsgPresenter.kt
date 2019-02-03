package com.sunfusheng.dagger2.kotlin.section2

import kotlinx.coroutines.*

/**
 * @author sunfusheng on 2019/1/31.
 */
class MsgPresenter {
    private var mView: IMsgView? = null
    private var mJob: Job? = null


    fun attachView(view: IMsgView) {
        this.mView = view
    }

    fun detachView() {
        this.mView = null
        this.mJob?.cancel()
    }

    fun getMsg() {
        mJob = GlobalScope.launch(Dispatchers.Main) {
            mView?.showMsg("Loading...")
            withContext(Dispatchers.Default) {
                delay(3000)
            }
//            doRequestAsync().await()
            mView?.showMsg("Done!")
        }
    }

    private suspend fun doRequestAsync() = GlobalScope.async(Dispatchers.Default) {
        delay(3000)
    }
}