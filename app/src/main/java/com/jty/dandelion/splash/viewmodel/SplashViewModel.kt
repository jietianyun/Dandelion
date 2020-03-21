package com.jty.dandelion.splash.viewmodel

import android.app.Activity
import android.content.Context.MODE_PRIVATE
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jty.dandelion.application.DandelionApplication

class SplashViewModel : ViewModel() {

    val loginStatus : MutableLiveData<String> by lazy {
        MutableLiveData<String>()
    }


    fun checkLogin(activity: Activity?){
        loginStatus.value = DandelionApplication.getAccount().getAccountId(activity)
    }
}
