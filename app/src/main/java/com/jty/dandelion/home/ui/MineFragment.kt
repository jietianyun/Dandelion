package com.jty.dandelion.home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jty.dandelion.R

class MineFragment : Fragment(){


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        Log.d("Fragment","MineFragment_oncreateview")
        return inflater.inflate(R.layout.fragment_mine, container, false)
    }
}