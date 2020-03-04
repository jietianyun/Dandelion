package com.jty.dandelion.splash.viewmodel

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SplashViewModel : ViewModel() {

    val loginStatus : MutableLiveData<Boolean> by lazy {
        MutableLiveData<Boolean>()
    }


    fun checkLogin(activity: Activity?){
        val sp = activity?.getSharedPreferences("login_status",MODE_PRIVATE)
        loginStatus.value = sp?.getBoolean("isLogin", false) ?: false
    }
}