package com.example.experiment3.Student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.experiment3.BaseActivity
import com.example.experiment3.R
import com.example.experiment3.Student.RecyclerView.important_inform
import kotlinx.android.synthetic.main.left_frag.*
import java.io.BufferedReader
import java.io.InputStream
import java.io.InputStreamReader

class LeftFragment : Fragment() {

    private var isTwoPane = false

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.left_frag, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        isTwoPane = activity?.findViewById<View>(R.id.RightMainFrag) != null
        //设置重要通知
        val layoutManager = LinearLayoutManager(activity)
        importantInformRecyclerView.layoutManager = layoutManager
        val adapter = StudentMenu.ImportantInformAdapter(getInform())
        importantInformRecyclerView.adapter=adapter
    }

    private fun getInform(): ArrayList<important_inform> {
        val informList = ArrayList<important_inform>()
        val input = activity?.openFileInput("important_information.txt")
        val reader = BufferedReader(InputStreamReader(input))
        var line = 0
        val type = ArrayList<String>()
        val title = ArrayList<String>()
        reader.use {
            reader.forEachLine {
                line += 1
                if (line % 2 == 1){
                    var str= "[$it]"
                    type.add(str)
                }

                else if (line % 2 == 0)
                    title.add(it)
            }
        }
        for (i in type.indices) {
            informList.add(important_inform(type[i], title[i]))
        }
        return informList
    }
}