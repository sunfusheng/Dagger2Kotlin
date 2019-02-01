package com.sunfusheng.dagger2.kotlin.section2

import kotlinx.coroutines.*

/**
 * @author sunfusheng on 2019/1/31.
 */
class MsgPresenter {
    private var mView: IMsgView? = null
    private val mJobs: ArrayList<Job> = ArrayList()


    fun attachView(view: IMsgView) {
        this.mView = view
    }

    fun detachView() {
        this.mView = null

        for (job in mJobs) {
            job.cancel()
        }
    }

    fun getMsg() {
        GlobalScope.launch {
            val job = async {
                mView?.showMsg("Loading...")
                delay(3000)
                mView?.showMsg("Done!")
                true
            }
            mJobs.add(job)
        }
    }
}