package com.wy.mvp.impl

import android.content.res.Configuration
import android.os.Bundle
import com.wy.mvp.IMvpView
import com.wy.mvp.IPresenter

/* 名称: GitHubApp.com.wy.mvp.impl.BasePresenter
  * 用户: _VIEW
  * 时间: 2019/9/2,16:58
  * 描述: ToDo
  */
abstract class BasePresenter<out V : IMvpView<BasePresenter<V>>> : IPresenter<V> {

    override lateinit var view: @UnsafeVariance V

    override fun onCreate(savedInstanceState: Bundle?) = Unit

    override fun onSaveInstanceState(outState: Bundle) = Unit

    override fun onViewStateRestored(savedInstanceState: Bundle?) = Unit

    override fun onConfigurationChanged(newConfig: Configuration) = Unit

    override fun onDestroy() = Unit
    override fun onStart() = Unit

    override fun onStop() = Unit

    override fun onResume() = Unit

    override fun onPause() = Unit
}