package com.jty.dandelion.customview

import android.content.Context
import android.graphics.*
import android.graphics.drawable.BitmapDrawable
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatImageView

class CircleImageView : AppCompatImageView{

constructor(context: Context):this(context,null)
    constructor(context: Context,attrs: AttributeSet?):this(context,attrs,0)
    constructor(context: Context,attrs: AttributeSet?,defStyleAttr: Int):super(context,attrs,defStyleAttr)

    private val paint = Paint().apply { isAntiAlias = true }
    private val mMatrix = Matrix()
    var mHeight = 0F
    var mWidth = 0F
    var mRadius = 0F



    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mWidth = measuredWidth.toFloat()
        mHeight = measuredHeight.toFloat()
        mRadius = Math.min(mHeight,mWidth)/2
    }

    override fun onDraw(canvas: Canvas?) {
        val drawable = drawable
        if (drawable == null){
            super.onDraw(canvas)
            return
        }
        if(drawable is BitmapDrawable){
           val bitmapShader = initBitmapShader(drawable)
            paint.shader = bitmapShader
            canvas?.drawCircle(mWidth/2,mHeight/2,mRadius,paint)
            return
        }
        super.onDraw(canvas)
    }

    private fun  initBitmapShader(drawable: BitmapDrawable): BitmapShader{
        val bitmap = drawable.bitmap
        val bitmapwidth = bitmap.width
        val bitmapHeight = bitmap.height
        val bitmapShader = BitmapShader(bitmap,Shader.TileMode.CLAMP,Shader.TileMode.CLAMP)
        val scale = Math.max(mWidth/bitmapwidth,mHeight/bitmapHeight)
        mMatrix.setScale(scale,scale)
        bitmapShader.setLocalMatrix(mMatrix)
        return bitmapShader
    }




}