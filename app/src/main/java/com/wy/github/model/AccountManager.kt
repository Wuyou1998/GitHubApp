package com.wy.github.model

import com.google.gson.Gson
import com.wy.github.network.entities.AuthorizationReq
import com.wy.github.network.entities.AuthorizationRsp
import com.wy.github.network.entities.User
import com.wy.github.network.services.Authservice
import com.wy.github.network.services.UserService
import com.wy.github.utils.fromJson
import com.wy.github.utils.pref
import retrofit2.HttpException
import rx.Observable
import rx.android.schedulers.AndroidSchedulers
import rx.schedulers.Schedulers

/* 名称: GitHubApp.com.wy.github.model.AccountManager
  * 用户: _VIEW
  * 时间: 2019/9/3,23:28
  * 描述: 账户管理
  */
object AccountManager {
    //传空表示就是以变量名为Key存储的
    var authId by pref(-1)
    var userName by pref("")
    var password by pref("")
    var token by pref("")

    private var userJson by pref("")

    var currentUser: User? = null
        get() {
            if (field == null && userJson.isNotEmpty()) {
                field = Gson().fromJson<User>(userJson)
            }
            return field
        }
        set(value) {
            if (value == null) {
                userJson = ""
            } else {
                userJson = Gson().toJson(value)
            }
            field = value
        }

    fun isLogging(): Boolean = token.isNotEmpty()

    fun login() = Authservice.createAuthorization(AuthorizationReq())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribeOn(Schedulers.io())
        .doOnNext {
            if (it.token.isEmpty())
                throw AccountException(it)
        }.retryWhen {
            it.flatMap {
                if (it is AccountException) {
                    Authservice.deleteAuthorization(it.authorizationRsp.id)
                } else {
                    Observable.error(it)
                }
            }
        }.flatMap {
            token = it.token
            authId = it.id
            UserService.getAuthenticatedUser()
        }.map {
            currentUser = it
        }

    fun logout() = Authservice.deleteAuthorization(authId)
        .doOnNext {
            if (it.isSuccessful) {
                authId = -1
                token = ""
                currentUser = null
            } else {
                throw HttpException(it)
            }
        }

    class AccountException(val authorizationRsp: AuthorizationRsp) : Exception("Already logged in.")
}