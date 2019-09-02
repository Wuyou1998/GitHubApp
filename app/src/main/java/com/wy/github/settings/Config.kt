package com.wy.github.settings

import com.wy.common.log.logger
import com.wy.github.application.AppContext
import com.wy.github.utils.deviceId

/* 名称: GitHubApp.com.wy.github.constants.Config
  * 用户: _VIEW
  * 时间: 2019/9/2,21:30
  * 描述: 一些配置信息
  */
object Configs {

    object Account {
        val SCOPES = listOf("user", "repo", "notifications", "gist", "admin:org")
        const val clientId = "95c1af90b0be2a022350"
        const val clientSecret = "591fcd8b180d1d0ed33ee82f3dfabe6ce63401cc"
        const val note = "https://github.com/Wuyou1998"
        const val noteUrl = "https://github.com/Wuyou1998/GitHubApp"

        val fingerPrint by lazy {
            (AppContext.deviceId + clientId).also { logger.info("fingerPrint: " + it) }
        }
    }

}