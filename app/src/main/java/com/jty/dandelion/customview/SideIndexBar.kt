package com.jty.dandelion.customview

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.util.Log
import android.util.TypedValue
import android.view.MotionEvent
import android.view.View

class SideIndexBar : View{

    private var mHeight = 0
    private var mWidth = 0
    private var itemHeight = 0
    private var mLetter = ""
    var onTouchLetter: (letter:String)->Unit ={}
    var onTouchLetterUp: ()->Unit = {}
    private val notSelectPaint = Paint().apply {
        isAntiAlias = true
        textSize = spTopx(12)
        color = Color.BLACK
    }
    private val selectPaint = Paint().apply {
        isAntiAlias = true
        textSize = spTopx(12)
        color = Color.parseColor("#00BFFF")
    }

    private val fontMetrics = notSelectPaint.fontMetrics


    private val letters = arrayOf(
        "A","B","C","D","E",
        "F","G","H","I","J",
        "K","L","M","N","O",
        "P","Q","R","S","T",
        "U","V","W","X","Y",
        "Z","#")

    constructor(context: Context): this(context, null)
    constructor(context: Context, attrs: AttributeSet?):this(context,attrs,0)
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int): super(context,attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        mHeight = MeasureSpec.getSize(heightMeasureSpec)
        val letterWidth= notSelectPaint.measureText("A")
        mWidth = paddingLeft+paddingRight+letterWidth.toInt()
        itemHeight= (mHeight-paddingTop-paddingBottom)/letters.size
        setMeasuredDimension(mWidth,mHeight)
    }

    override fun onDraw(canvas: Canvas?) {
       for (i in 0 until letters.size){
           val letter = letters[i]
           val letterCenter = i*itemHeight+itemHeight/2+paddingTop
           val x = (mWidth/2)-(notSelectPaint.measureText(letter)/2)
           val dy = (fontMetrics.bottom-fontMetrics.top)-fontMetrics.bottom
           val baseLine  = letterCenter+dy
           if (mLetter==letter){
               canvas?.drawText(letter, x, baseLine, selectPaint)
           }else {
               canvas?.drawText(letter, x, baseLine, notSelectPaint)
           }
       }
    }

    @SuppressLint("ClickableViewAccessibility")
    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when(event?.action){
            MotionEvent.ACTION_DOWN ->{}
            MotionEvent.ACTION_MOVE ->{
                Log.d("SideIndexBar","y=${event.y}")
                var position = (event.y/itemHeight).toInt()
                if (position<0){position = 0}
                if (position>letters.size-1){position = letters.size-1}
                mLetter= letters[position]
                onTouchLetter(mLetter)
                Log.d("SideIndexBar","mLetter=$mLetter")
                invalidate()
            }
            MotionEvent.ACTION_UP ->{
                mLetter=""
                invalidate()
                onTouchLetterUp()
            }
            MotionEvent.ACTION_CANCEL ->{
                mLetter=""
                invalidate()
                onTouchLetterUp()
            }
        }
        return true
    }

    private fun spTopx(sp: Int): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_SP, sp.toFloat(),resources.displayMetrics)
    }
}