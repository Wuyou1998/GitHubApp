package com.wy.github.network.services

import com.wy.github.network.entities.User
import com.wy.github.network.retrofit
import retrofit2.http.GET
import rx.Observable

/* 名称: GitHubApp.com.wy.github.network.services.UserService
  * 用户: _VIEW
  * 时间: 2019/9/3,23:12
  * 描述: 用户
  */
interface UserApi {
    @GET("/user")
    fun getAuthenticatedUser(): Observable<User>
}

object UserService : UserApi by retrofit.create(UserApi::class.java)