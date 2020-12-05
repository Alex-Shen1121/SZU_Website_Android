package com.example.experiment3.Student

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.experiment3.BaseActivity
import com.example.experiment3.R
import kotlinx.android.synthetic.main.activity_right_main.*

class RightMainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_right_main)
        val fragment=RightMainFrag as RightFragment
        fragment.refresh()
    }

    companion object{
        fun actionstart(context:Context,title:String,content:String){
            val intent=Intent(context,RightMainActivity::class.java)
            context.startActivity(intent)
        }
    }
}