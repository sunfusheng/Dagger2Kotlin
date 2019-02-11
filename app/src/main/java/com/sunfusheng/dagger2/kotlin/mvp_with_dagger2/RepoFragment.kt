package com.sunfusheng.dagger2.kotlin.mvp_with_dagger2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunfusheng.dagger2.kotlin.R
import kotlinx.android.synthetic.main.fragment_text.*
import javax.inject.Inject

/**
 * @author by sunfusheng on 2019/2/7
 */
class RepoFragment : Fragment(), IRepoView {

    @Inject
    lateinit var mPresenter: RepoPresenter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerRepoComponent.builder()
            .repoModule(RepoModule(this))
            .build()
            .inject(this)

        lifecycle.addObserver(mPresenter)
        mPresenter.fetchRepo()
    }

    override fun onRepoCallback(repo: Repo) {
        vText.text = repo.reponame
    }
}