package com.wy.mvp

import android.content.res.Configuration
import android.os.Bundle

/* 名称: GitHubApp.com.wy.mvp.ILifecycle
  * 用户: _VIEW
  * 时间: 2019/9/2,16:55
  * 描述: 生命周期接口
  */
interface ILifecycle {
    fun onCreate(savedInstanceState: Bundle?)

    fun onSaveInstanceState(outState: Bundle)

    fun onViewStateRestored(savedInstanceState: Bundle?)

    fun onConfigurationChanged(newConfig: Configuration)

    fun onDestroy()

    fun onStart()

    fun onStop()

    fun onResume()

    fun onPause()
}