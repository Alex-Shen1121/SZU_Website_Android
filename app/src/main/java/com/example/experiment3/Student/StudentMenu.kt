package com.example.experiment3.Student

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.experiment3.BaseActivity
import com.example.experiment3.R
import com.example.experiment3.Student.RecyclerView.important_inform
import kotlinx.android.synthetic.main.left_frag.*

class StudentMenu : BaseActivity() {

    var isTwoPane=false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student_menu)
        supportActionBar?.hide()
        isTwoPane = findViewById<View>(R.id.StudentRightLayout) != null
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
        szu_website_button.setOnClickListener() {
            if(!isTwoPane){
                val intent = Intent(this, RightMainActivity::class.java)
                startActivity(intent)
            }

        }

    }

    class ImportantInformAdapter(val informList: List<important_inform>) :
        RecyclerView.Adapter<ImportantInformAdapter.ViewHolder>() {

        inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
            val importantInformType: TextView = view.findViewById(R.id.type)
            val importantInformTitle: TextView = view.findViewById(R.id.title)
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.important_inform_item, parent, false)
            return ViewHolder(view)
        }

        override fun getItemCount() = informList.size

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
            var inform = informList[position]
            holder.importantInformTitle.text = inform.title
            holder.importantInformType.text = inform.type
        }
    }
}