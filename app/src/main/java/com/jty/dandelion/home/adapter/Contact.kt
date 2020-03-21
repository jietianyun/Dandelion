package com.jty.dandelion.home.adapter

import android.os.Parcelable
import com.jty.dandelion.register.bean.User
import kotlinx.android.parcel.Parcelize
@Parcelize
data class Contact(
    val nameType: String,
    val user: User
):Parcelable