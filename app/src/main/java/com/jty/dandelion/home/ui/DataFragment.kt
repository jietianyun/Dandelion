package com.jty.dandelion.home.ui

import android.content.Context
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
        Log.d("HomeAdapter","${this.javaClass.simpleName}_oncreateview")
        return inflater.inflate(R.layout.fragment_data, container, false)
    }

    override fun onResume() {
        super.onResume()
        Log.d("HomeAdapter","${this.javaClass.simpleName}_onResume")
    }


    override fun onDestroy() {
        super.onDestroy()
        Log.d("HomeAdapter","${this.javaClass.simpleName}_onDestroy")
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("HomeAdapter","${this.javaClass.simpleName}_onCreate")
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        Log.d("HomeAdapter","${this.javaClass.simpleName}_onAttach")
    }

    override fun onDetach() {
        super.onDetach()
        Log.d("HomeAdapter","${this.javaClass.simpleName}_onAttach")
    }

    override fun onStart() {
        super.onStart()
        Log.d("HomeAdapter","${this.javaClass.simpleName}_onStart")
    }

    override fun onPause() {
        super.onPause()
        Log.d("HomeAdapter","${this.javaClass.simpleName}_onPause")
    }
}