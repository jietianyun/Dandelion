package com.jty.dandelion.home.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.jty.dandelion.R

class DataFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        Log.d("Fragment","DataFragment_oncreateview")
        return inflater.inflate(R.layout.fragment_data, container, false)
    }
}