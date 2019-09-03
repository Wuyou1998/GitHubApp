package com.wy.github.network.interceptoros

import android.util.Base64
import com.wy.github.model.AccountManager
import okhttp3.Interceptor
import okhttp3.Response


/* 名称: GitHubApp.com.wy.github.network.interceptoros.AuthInterceptor
  * 用户: _VIEW
  * 时间: 2019/9/3,23:23
  * 描述: 验证 拦截器
  */
class AuthInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val original = chain.request()
        return chain.proceed(original.newBuilder()
            .apply {
                when {
                    original.url().pathSegments().contains("authorizations") -> {
                        val userCredentials =
                            AccountManager.userName + ":" + AccountManager.password
                        val auth = "Basic" + String(
                            Base64.encode(
                                userCredentials.toByteArray(),
                                Base64.DEFAULT
                            )
                        ).trim()
                        header("Authorization", auth)
                    }
                    AccountManager.isLogging() -> {
                        val auth = "Token" + AccountManager.token
                        header("Authorization", auth)
                    }
                    else -> removeHeader("Authorization")
                }
            }
            .build())
    }

}