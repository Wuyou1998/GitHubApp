package com.wy.github.network.interceptoros

import okhttp3.Interceptor
import okhttp3.Response

/* 名称: GitHubApp.com.wy.github.network.interceptoros.AcceptInterceptor
  * 用户: _VIEW
  * 时间: 2019/9/3,23:43
  * 描述: ToDo
  */
class AcceptInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()
        return chain.proceed(original.newBuilder()
            .apply {
                header(
                    "accept",
                    "application/vnd.github.v3.full+json, ${original.header("accept") ?: ""}"
                )
            }
            .build())

    }

}