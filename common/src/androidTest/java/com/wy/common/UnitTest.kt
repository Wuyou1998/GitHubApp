package com.wy.common

import com.wy.common.ext.yes
import org.junit.Test

/* 名称: GitHubApp.com.wy.common.UnitTest
  * 用户: _VIEW
  * 时间: 2019/9/1,14:47
  * 描述: ToDo 单元测试bug的一批，等我回头再弄 妈卖批
  */
class UnitTest() {
    @Test
    fun testBoolean() {
        true.yes {
            print(123)
        }
    }
}