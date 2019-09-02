package com.wy.github.utils

import android.content.Context
import android.provider.Settings

/* 名称: GitHubApp.com.wy.github.utils.DeviceId
  * 用户: _VIEW
  * 时间: 2019/9/2,21:25
  * 描述: 获取设备id
  */
val Context.deviceId: String
    get() {
        return Settings.Secure.getString(contentResolver, Settings.Secure.ANDROID_ID)
    }