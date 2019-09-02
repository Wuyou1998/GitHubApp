package com.wy.github.utils

import com.wy.common.sharedPreferences.Preference
import com.wy.github.application.AppContext
import kotlin.reflect.jvm.jvmName

/* 名称: GitHubApp.com.wy.github.utils.PrefExt
  * 用户: _VIEW
  * 时间: 2019/9/2,21:47
  * 描述: sharedPreference 扩展
  */
inline fun <reified R, T> R.pref(default: T) = Preference(AppContext, "", default, R::class.jvmName)