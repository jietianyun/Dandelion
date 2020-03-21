package com.jty.dandelion.home.ui

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.jty.dandelion.R
import com.jty.dandelion.home.adapter.NewsAdapter
import kotlinx.android.synthetic.main.fragment_news.*

class NewsFragment : Fragment(){

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        Log.d("HomeAdapter","${this.javaClass.simpleName}_oncreateview")
        return inflater.inflate(R.layout.fragment_news, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
//        bt_test.setOnClickListener {
//            findNavController().navigate(R.id.testFragment)
//        }
    }
    fun initView(){
        news_rl.layoutManager = LinearLayoutManager(activity)
        news_rl.adapter = NewsAdapter()
    }



}