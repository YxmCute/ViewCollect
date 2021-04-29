package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yxmcute.viewcollect.globalColor

class ArcView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint().apply {
        color = globalColor
        strokeWidth = 5f
        isAntiAlias=true
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.also {
            paint.style = Paint.Style.FILL
            it.drawArc(100f, 100f, 400f, 300f, 0f, 158f, false, paint)
            paint.style = Paint.Style.STROKE
            it.drawArc(100f, 100f, 400f, 300f, 0f, -45f, true, paint)
        }
    }
}