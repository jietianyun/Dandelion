package com.jty.dandelion.application

import android.app.Activity
import android.content.Context

class Account {

    fun saveAcountId(id: String, activity: Activity?){
        val sp = activity?.getSharedPreferences("Account", Context.MODE_PRIVATE)
        val editor = sp?.edit()
        editor?.putString("AccountId",id)
        editor?.apply()
    }

    fun getAccountId(activity: Activity?): String?{
        val sp = activity?.getSharedPreferences("Account", Context.MODE_PRIVATE)
         return sp?.getString("AccountId","")
    }
}