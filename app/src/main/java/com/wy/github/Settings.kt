package com.wy.github

import com.wy.common.Preference
import com.wy.github.application.AppContext

/* 名称: GitHubApp.com.wy.github.Settings
  * 用户: _VIEW
  * 时间: 2019/9/1,15:49
  * 描述: 属性代理 从sp中获取值
  */
object Settings {
    var email: String by Preference(AppContext, "email", "")
    var password: String by Preference(AppContext, "password", "")
}