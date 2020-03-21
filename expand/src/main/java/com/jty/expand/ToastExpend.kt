package com.jty.expand

import android.app.Activity
import android.widget.Toast

fun Activity.showToast(message: String){
    Toast.makeText(this.applicationContext,message,Toast.LENGTH_SHORT).show()
}

fun Activity.showToast(id: Int){
    this.showToast(this.resources.getString(id))
}

fun Activity.showLongToast(message: String){
    Toast.makeText(this.applicationContext,message,Toast.LENGTH_LONG).show()
}

fun Activity.showLongToast(id: Int){
    this.showLongToast(this.resources.getString(id))
}