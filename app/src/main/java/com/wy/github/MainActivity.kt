package com.wy.github

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.layout_main.*

/* 名称: GitHubApp.com.wy.github.MainActivity
  * 用户: _VIEW
  * 时间: 2019/9/1,15:06
  * 描述: 主界面
  */
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.layout_main)
        edt_email.setText(Settings.email)
        edt_password.setText(Settings.password)

        btn_login.setOnClickListener {
            Settings.email = edt_email.text.toString().trim()
            Settings.password = edt_password.text.toString().trim()
        }
    }
}