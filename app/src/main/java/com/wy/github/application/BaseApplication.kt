package com.wy.github.application

import android.app.Application
import android.content.ContextWrapper

/* 名称: GitHubApp.com.wy.github.application.BaseApplication
  * 用户: _VIEW
  * 时间: 2019/9/1,15:46
  * 描述: Application
  */
private lateinit var INSTANCE: Application

class BaseApplication : Application() {
    override fun onCreate() {
        super.onCreate()
        INSTANCE = this
    }
}

object AppContext : ContextWrapper(INSTANCE)