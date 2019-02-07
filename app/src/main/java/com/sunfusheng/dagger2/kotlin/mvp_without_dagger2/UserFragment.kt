package com.sunfusheng.dagger2.kotlin.mvp_without_dagger2

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.sunfusheng.dagger2.kotlin.R
import kotlinx.android.synthetic.main.fragment_user.*

/**
 * @author by sunfusheng on 2019/2/1
 */
class UserFragment : Fragment(), IUserView {

    private val mPresenter: UserPresenter by lazy {
        UserPresenter()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return layoutInflater.inflate(R.layout.fragment_user, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        mPresenter.attachView(this)
        mPresenter.getMsg()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        mPresenter.detachView()
    }

    override fun showUser(user: User) {
        vUser.text = user.username
    }
}