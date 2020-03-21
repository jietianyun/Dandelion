package com.jty.dandelion.register.viewmodel


import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.jty.dandelion.net.HttpManager
import com.jty.dandelion.net.Result
import com.jty.dandelion.register.bean.User

class RegisterViewModel : ViewModel(){

    val registerResult by lazy {
        MutableLiveData<Result>()
    }

     fun registerUser(user: User){
     HttpManager.registerUser(user,registerResult)
    }


}