package com.wy.common.ext

import android.util.Log
import java.io.File

/* 名称: GitHubApp.com.wy.common.ext.FileExt
  * 用户: _VIEW
  * 时间: 2019/9/2,21:00
  * 描述: File类的扩展
  */
fun File.ensureDir(): Boolean {
    try {
        isDirectory.no {
            isFile.yes { delete() }
            return mkdirs()
        }
    }catch (e:Exception){
        Log.e("File.ensureDir",e.message)
    }
    return false
}