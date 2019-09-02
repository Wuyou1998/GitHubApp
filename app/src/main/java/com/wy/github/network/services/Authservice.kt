package com.wy.github.network.services


import com.wy.github.network.entities.AuthorizationReq
import com.wy.github.network.entities.AuthorizationRsp
import com.wy.github.network.retrofit
import com.wy.github.settings.Configs
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.DELETE
import retrofit2.http.PUT
import retrofit2.http.Path
import rx.Observable

/* 名称: GitHubApp.com.wy.github.network.services.Authservice
  * 用户: _VIEW
  * 时间: 2019/9/2,22:14
  * 描述: retrofit 接口 获取验证token
  */
interface AuthApi {
    @PUT("/authorization/clients/${Configs.Account.clientId}/{fingerPrint}")
    fun createAuthorization(
        @Body req: AuthorizationReq,
        @Path("fingerPrint") fingerPrint: String = Configs.Account.fingerPrint
    ): Observable<AuthorizationRsp>

    @DELETE("/authorizations/{id}")
    fun deleteAuthorization(@Path("id") id: Int): Observable<Response<Any>>
}

object Authservice : AuthApi by retrofit.create(AuthApi::class.java)
