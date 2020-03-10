package com.jty.expand

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.view.WindowManager
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

fun Activity.hideStatusBar() {
    window.addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

fun Activity.showStatusBar() {
    window.clearFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN)
}

inline fun <reified T>Activity.startActivity(bundle: Bundle = Bundle()){
   startActivity(Intent(this,T::class.java).apply {
           putExtras(bundle)
   })
}

inline fun <reified T : ViewModel> AppCompatActivity.getViewModel() : T{
    return ViewModelProvider(this).get(T::class.java)
}