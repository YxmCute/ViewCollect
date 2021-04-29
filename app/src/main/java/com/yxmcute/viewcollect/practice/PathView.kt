package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.View

class PathView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val path = Path()
    private val paint = Paint().apply { }
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
    }
}