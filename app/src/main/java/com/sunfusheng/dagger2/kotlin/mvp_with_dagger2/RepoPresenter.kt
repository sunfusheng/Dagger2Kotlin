package com.sunfusheng.dagger2.kotlin.mvp_with_dagger2

import android.arch.lifecycle.Lifecycle
import android.arch.lifecycle.LifecycleObserver
import android.arch.lifecycle.OnLifecycleEvent
import kotlinx.coroutines.*

/**
 * @author sunfusheng on 2019/2/7.
 */
class RepoPresenter(private val mView: IRepoView) : LifecycleObserver {
    private var mJob: Job? = null

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    fun onDestroy() {
        mJob?.cancel()
    }

    fun fetchRepo() {
        mJob = GlobalScope.launch(Dispatchers.Main) {
            val repo = fetchRepoAsync().await()
            mView.onRepoCallback(repo)
        }
    }

    private suspend fun fetchRepoAsync() = GlobalScope.async(Dispatchers.Default) {
        delay(3000)
        Repo("MarqueeView")
    }
}