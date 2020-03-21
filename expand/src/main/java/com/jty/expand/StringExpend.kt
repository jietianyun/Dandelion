package com.jty.expand

import android.text.TextUtils
import com.google.android.material.textfield.TextInputLayout

fun String.emptyHint(emptyErrorText: String,view : TextInputLayout): Boolean{
    return TextUtils.isEmpty(this).apply {
        view.isErrorEnabled = false
        if (this){
        view.isErrorEnabled = true
        view.error = emptyErrorText} }
}