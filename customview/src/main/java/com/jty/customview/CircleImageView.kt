package com.jty.customview

import android.content.Context
import android.graphics.Matrix
import android.graphics.Paint

import androidx.appcompat.widget.AppCompatImageView

class CircleImageView(context: Context) : AppCompatImageView(context) {

    val paint = Paint().apply { isAntiAlias=true }
    val matix = Matrix()
    var height = 0

}