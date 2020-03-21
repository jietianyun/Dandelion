package com.jty.dandelion.login.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jty.dandelion.net.HttpManager
import com.jty.dandelion.net.Result

class LoginViewModel : ViewModel(){

    val checkIsLogin by lazy {
        MutableLiveData<Result>()
    }

    fun checkLogin(account: String, password: String){
        HttpManager.LoginUser(account, password, checkIsLogin)
    }
}