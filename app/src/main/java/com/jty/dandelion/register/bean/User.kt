package com.jty.dandelion.register.bean

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import net.sourceforge.pinyin4j.PinyinHelper

@Parcelize
data class User(
    val name: String,
    val birthday: String? =null,
    val email: String? = null,
    val sex: String?= null,
    val password: String?= null,
    val phone: String?=null,
    val school: String?=null,
    val college: String?=null,
    val classId: String?=null,
    val id: String? = null,
    val createtime: Long?=0,
    val lastonlinetime: Long?=0,
    val studentId: String?=null
): Parcelable{
    fun getNamePinyin(): String{
        return ((PinyinHelper.toHanyuPinyinStringArray(name[0]))[0])[0].toString().toUpperCase()
    }

}