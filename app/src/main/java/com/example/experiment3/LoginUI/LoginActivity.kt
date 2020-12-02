package com.example.experiment3.LoginUI

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.example.experiment3.R
import kotlinx.android.synthetic.main.activity_login.*
import java.io.*

class LoginActivity : AppCompatActivity() {

    val accountList = mutableMapOf<String, String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        supportActionBar?.hide()
        //加入默认账号密码
        //管理员账号：admin 密码：123456
        //学生账号：admin 密码：123456
        addDefaultAccount()

        login.setOnClickListener(){
            //设置正确账号密码Map
            setAccountList()
            val account=accountEdit.text.toString()
            val password=passwordEdit.text.toString()
            //账号密码匹配成功
            if(accountList[account]==password){
                Toast.makeText(this,"登陆成功",Toast.LENGTH_SHORT).show()

            }
            else{
                AlertDialog.Builder(this).apply {
                    setTitle("登陆失败")
                    setMessage("请重新检查用户名与密码。\n 或者联系管理员。")
                    setCancelable(false)
                    setPositiveButton("OK"){_, _ ->}
                    show()
                }
            }
        }


    }

    private fun setAccountList(){
        val input = openFileInput("account_password.txt")
        val reader = BufferedReader(InputStreamReader(input))
        var line = 0
        val account = ArrayList<String>()
        val password = ArrayList<String>()
        reader.use {
            reader.forEachLine {
                line += 1
                if (line % 2 == 1)
                    account.add(it)
                else if (line % 2 == 0)
                    password.add(it)
            }
        }
        for (i in account.indices) {
            accountList[account[i]] = password[i]
        }
    }

    private fun addDefaultAccount(){
        val output=openFileOutput("account_password.txt", MODE_APPEND)
        val writer=BufferedWriter(OutputStreamWriter(output))
        writer.use {
            it.write("admin")
            it.newLine()
            it.write("123456")
            it.newLine()
            it.write("student")
            it.newLine()
            it.write("123456")
            it.newLine()
        }
    }
}