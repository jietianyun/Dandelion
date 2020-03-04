package com.jty.dandelion.main_activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jty.dandelion.R

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        hideSystemUi()
    }

    private fun hideSystemUi(){
        window?.decorView?.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
    }
}
