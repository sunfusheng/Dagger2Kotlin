package com.sunfusheng.dagger2.kotlin.mvp_without_dagger2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunfusheng.dagger2.kotlin.R
import kotlinx.android.synthetic.main.fragment_text.*

/**
 * @author by sunfusheng on 2019/2/1
 */
class UserFragment : Fragment(), IUserView {

    val mPresenter: UserPresenter by lazy {
        UserPresenter(this)
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_text, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.fetchUser()
    }

    override fun onDestroyView() {
        mPresenter.detachView()
        super.onDestroyView()
    }

    override fun onUserCallback(user: User) {
        vText.text = user.username
    }
}