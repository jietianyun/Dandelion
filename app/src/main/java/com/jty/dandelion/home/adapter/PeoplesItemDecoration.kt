package com.jty.dandelion.home.adapter

import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.Rect
import android.util.Log
import android.util.TypedValue
import android.view.View
import androidx.core.view.marginTop
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlin.collections.LinkedHashMap

class PeoplesItemDecoration : RecyclerView.ItemDecoration() {

    var groupHeaderTop = 0
    var groupHeaderLeft = 0
    private val rectPaint = Paint().apply {
        isAntiAlias = true
        color = Color.parseColor("#D3D3D3")
    }
    private val textPaint = Paint().apply {
        isAntiAlias = true
        textSize = 40.toFloat()
        color = Color.BLACK
    }
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        val layoutManger = parent.layoutManager
        if (layoutManger !is LinearLayoutManager && (layoutManger as? LinearLayoutManager)?.orientation != LinearLayoutManager.VERTICAL) {
            return
        }
        val position = parent.getChildAdapterPosition(view)
        val contactList = (parent.adapter as? PeoplesAdapter)?.contactList
        contactList ?: return
        if (contactList.isNotEmpty() && checkNameType(contactList, position)) {
            outRect.top = dpTopx(groupHeaderTop, parent).toInt()
        }
    }


    override fun onDraw(c: Canvas, parent: RecyclerView, state: RecyclerView.State) {
        super.onDraw(c, parent, state)
        Log.d("PeoplesAdapter", "onDraw")
        val contactList = (parent.adapter as? PeoplesAdapter)?.contactList
        contactList ?: return
        for (i in 0 until parent.childCount) {
            val view = parent.getChildAt(i)
            val position = (view.layoutParams as? RecyclerView.LayoutParams)?.viewLayoutPosition ?:i
            if (contactList.isNotEmpty() && checkNameType(contactList, position)) {
                drawGroupHeader(c, parent, view, contactList[position].nameType)
            }
        }
//        nameTypePositionMap.forEach {
//            val view = parent.getChildAt(it.key)
//            Log.d("PeoplesAdapter", "onDraw:{$it")
//            if(view!=null) {
//                drawGroupHeader(c, parent, view, it.value)
//            }
//        }

    }

    fun drawGroupHeader(c: Canvas, parent: RecyclerView, view: View, tag: String) {
        val left = (parent.paddingLeft).toFloat()
        val right = (parent.width - parent.paddingRight).toFloat()
        val bottom = (view.top - view.marginTop).toFloat()
        val top = bottom - dpTopx(groupHeaderTop, parent)
        Log.d("PeoplesAdapter", "left:$left-right:$right-bottom:$bottom-top:$top")
        c.drawRect(left, top, right, bottom, rectPaint)
        val x = left + groupHeaderLeft
        val y = bottom - (bottom - top) / 2 + textPaint.measureText(tag) / 2
        c.drawText(tag, x, y, textPaint)
    }

    private fun checkNameType(contactList: MutableList<Contact>, position: Int): Boolean{
        return (position == 0 || contactList[position].nameType != contactList[position - 1].nameType)
    }

    private fun dpTopx(dp: Int, parent: RecyclerView): Float {
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp.toFloat(), parent.resources.displayMetrics)
    }
}