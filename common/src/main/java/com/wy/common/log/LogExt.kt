package com.wy.common.log

import org.slf4j.Logger
import org.slf4j.LoggerFactory


/* 名称: GitHubApp.com.wy.common.log.LogExt
  * 用户: _VIEW
  * 时间: 2019/9/2,21:05
  * 描述: 打日志
  */
val logMap = HashMap<Class<*>, Logger>()
inline val <reified T> T.logger: Logger
    get() {
        return logMap[T::class.java]
            ?: LoggerFactory.getLogger(T::class.java).apply { logMap[T::class.java] = this }
    }