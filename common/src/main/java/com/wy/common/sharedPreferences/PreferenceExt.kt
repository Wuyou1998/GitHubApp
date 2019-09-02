package com.wy.common.sharedPreferences

import android.content.Context
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/* 名称: GitHubApp.com.wy.common.PreferenceExt
  * 用户: _VIEW
  * 时间: 2019/9/1,15:26
  * 描述: SharedPreference 扩展
  */
class Preference<T>(
    private val context: Context,
    private val name: String,
    private val default: T,
    private val prefName: String = "default"
) : ReadWriteProperty<Any?, T> {
    private val sp by lazy {
        context.getSharedPreferences(prefName, Context.MODE_PRIVATE)
    }

    override fun getValue(thisRef: Any?, property: KProperty<*>): T {
        return getPreference(name)
    }

    override fun setValue(thisRef: Any?, property: KProperty<*>, value: T) {
        putPreference(name, value)
    }

    private fun getPreference(key: String): T {
        return when (default) {
            is Long -> sp.getLong(key, default)
            is Int -> sp.getInt(key, default)
            is Float -> sp.getFloat(key, default)
            is Boolean -> sp.getBoolean(key, default)
            is String -> sp.getString(key, default)
            else -> throw IllegalArgumentException("不支持的类型")
        } as T
    }

    private fun putPreference(key: String, value: T) {
        with(sp.edit()) {
            when (value) {
                is Long -> putLong(name, value)
                is Int -> putInt(name, value)
                is Float -> putFloat(name, value)
                is Boolean -> putBoolean(name, value)
                is String -> putString(name, value)
                else -> throw IllegalArgumentException("不支持的类型")
            }.apply()
        }
    }
}