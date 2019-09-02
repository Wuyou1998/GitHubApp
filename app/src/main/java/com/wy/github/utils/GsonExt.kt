package com.wy.github.utils

import com.google.gson.Gson

/* 名称: GitHubApp.com.wy.github.utils.GsonExt
  * 用户: _VIEW
  * 时间: 2019/9/2,21:36
  * 描述: Gson 扩展
  */
inline fun <reified T> Gson.fromJson(json: String) = fromJson(json, T::class.java)