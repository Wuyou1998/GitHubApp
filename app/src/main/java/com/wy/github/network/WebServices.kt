package com.wy.github.network

import com.wy.common.ext.ensureDir
import com.wy.github.application.AppContext
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit

/* 名称: GitHubApp.com.wy.github.network.services.WebServices
  * 用户: _VIEW
  * 时间: 2019/9/2,21:58
  * 描述: 网络请求配置
  */

private const val BASE_URL = "http://api.github.com"

private val cacheFile by lazy {
    File(AppContext.cacheDir, "webServiceApi").apply { ensureDir() }
}

val retrofit by lazy {
    Retrofit.Builder()
        .addConverterFactory(GsonConverterFactory.create())
        .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
        .client(
            OkHttpClient.Builder()
                .connectTimeout(60, TimeUnit.SECONDS)
                .readTimeout(60, TimeUnit.SECONDS)
                .writeTimeout(60, TimeUnit.SECONDS)
                .cache(Cache(cacheFile, 1024 * 1024 * 128))
                .addInterceptor(HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build()
        ).baseUrl(BASE_URL)
        .build()
}