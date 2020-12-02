package com.example.experiment3.Admin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experiment3.R
import kotlinx.android.synthetic.main.activity_admin_menu.*

class AdminMenu : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_menu)
        var user_name = "用户名:"
        var user_identity = "身份:"
        user_name += intent.getStringExtra("userName")
        user_identity += intent.getStringExtra("userIdentity")
        userName.text = user_name
        userIdentity.text = user_identity


    }
}