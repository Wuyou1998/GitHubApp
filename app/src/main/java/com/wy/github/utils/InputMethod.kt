package com.wy.github.utils

import android.app.Activity
import android.content.Context
import android.view.View
import android.view.inputmethod.InputMethodManager
import org.jetbrains.anko.inputMethodManager

/* 名称: GitHubApp.com.wy.github.utils.InputMethod
  * 用户: _VIEW
  * 时间: 2019/9/2,21:37
  * 描述: 打开关闭输入法
  */
fun Context.toggleSoftInput() {
    inputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS)
}

fun View.showSoftInput(): Boolean {
    return context.inputMethodManager.showSoftInput(this, InputMethodManager.SHOW_FORCED)
}

fun Activity.showSoftInput(): Boolean {
    return currentFocus?.showSoftInput() ?: false
}

fun View.hideSoftInput(): Boolean {
    return context.inputMethodManager.hideSoftInputFromWindow(windowToken, 0)
}

fun Activity.hideSoftInput(): Boolean {
    return currentFocus?.hideSoftInput() ?: false
}

fun Context.isActive(): Boolean {
    return inputMethodManager.isActive
}