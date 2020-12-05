package com.example.experiment3.Student

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experiment3.BaseActivity
import com.example.experiment3.R
import kotlinx.android.synthetic.main.activity_admin_menu.*
import kotlinx.android.synthetic.main.activity_admin_menu.ForceOffline
import kotlinx.android.synthetic.main.activity_admin_menu.userIdentity
import kotlinx.android.synthetic.main.activity_admin_menu.userName
import kotlinx.android.synthetic.main.left_frag.*

class StudentMenu : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_menu)
        supportActionBar?.hide()
        //设置个人信息
        var user_name = "用户名:"
        var user_identity = "身份:"
        user_name += intent.getStringExtra("userName")
        user_identity += intent.getStringExtra("userIdentity")
        userName.text = user_name
        userIdentity.text = user_identity

        //设置强制下线
        ForceOffline.setOnClickListener() {
            val intent = Intent("com.example.experiment3.FORCE_OFFLINE")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }

        //进入内部网
        szu_website_button.setOnClickListener(){
            val intent=Intent(this,RightMainActivity::class.java)
            startActivity(intent)
        }

    }
}