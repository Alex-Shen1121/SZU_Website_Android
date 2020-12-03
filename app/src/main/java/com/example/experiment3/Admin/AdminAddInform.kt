package com.example.experiment3.Admin

import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Gravity
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.TextView
import com.example.experiment3.BaseActivity
import com.example.experiment3.R
import kotlinx.android.synthetic.main.activity_admin_add_inform.*
import kotlinx.android.synthetic.main.activity_admin_menu.*
import kotlinx.android.synthetic.main.activity_admin_menu.userIdentity
import kotlinx.android.synthetic.main.activity_admin_menu.userName

class AdminAddInform : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_add_inform)
        supportActionBar?.hide()
        //设置个人信息
        var user_name = intent.getStringExtra("userName")
        var user_identity = intent.getStringExtra("userIdentity")
        userName.text = user_name
        userIdentity.text = user_identity

        //设置强制下线
        ForceOffline1.setOnClickListener() {
            val intent = Intent("com.example.experiment3.FORCE_OFFLINE")
            intent.setPackage(packageName)
            sendBroadcast(intent)
        }

        //设置栏目
        var column_title = "修改栏目："
        column_title += intent.getStringExtra("column")
        columnTitle.text = column_title

        //编辑布局
        when (intent.getStringExtra("column")) {
            "重要通知" -> {
                informType.visibility = View.VISIBLE
                informTitle.visibility = View.VISIBLE
                //设置通知类别下拉框
                val mItems = arrayOf("讲座", "教务", "科研","行政","学工","生活")
                val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, mItems)
                adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
                informType.adapter = adapter
                informType.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
                    override fun onItemSelected(parent: AdapterView<*>?, view: View, pos: Int, id: Long) {
                        // TODO
                        val tv = view as TextView
                        tv.setTextColor(Color.BLUE)
                        tv.textSize = 20f
                        tv.gravity = Gravity.CENTER
                    }

                    override fun onNothingSelected(parent: AdapterView<*>) {
                        // TODO

                    }
                }

            }
            "学术讲座" -> {
                dateTime.visibility = View.VISIBLE
                place.visibility = View.VISIBLE
                blank.visibility = View.VISIBLE
                blank2.visibility = View.VISIBLE
                informTitle.visibility = View.VISIBLE
            }
            "深大新闻" -> {
                informTitle.visibility = View.VISIBLE
            }
        }


    }
}