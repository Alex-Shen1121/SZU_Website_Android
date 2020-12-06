package com.example.experiment3.Student

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.experiment3.R
import kotlinx.android.synthetic.main.right_frag.*

class RightFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.right_frag, container, false)
    }

    fun refresh() {
        contentLayout.visibility = View.VISIBLE
    }

}