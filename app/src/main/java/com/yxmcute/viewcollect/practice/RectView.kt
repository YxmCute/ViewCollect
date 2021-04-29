package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.graphics.RectF
import android.util.AttributeSet
import android.view.View

class RectView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val rectF = RectF()

    init {
        paint.color = Color.parseColor("#88880000")
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        rectF.set(0f, 0f, width / 2.toFloat(), height / 2.toFloat())
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //练习内容：使用 canvas.drawRect() 方法画矩形
        canvas?.also {
            it.drawRect(rectF, paint)

        }
    }
}