package com.jty.expand

import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

inline fun <reified T : ViewModel> Fragment.getViewModel() : T{
   return ViewModelProvider(this).get(T::class.java)
}