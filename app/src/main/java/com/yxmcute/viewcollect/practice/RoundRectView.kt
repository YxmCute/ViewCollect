package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yxmcute.viewcollect.globalColor

class RoundRectView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint().apply {
        color = globalColor
        strokeWidth = 5f
        style = Paint.Style.STROKE
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.also {
            //rx ，ry的最大值应宽高的一半，大了不会报错，因为系统判断rx，ry大于宽高的一半的时：rx，ry会等于宽高的一半
            it.drawRoundRect(100f, 100f, 500f, 400f, 50f, 30f, paint)

            /* it.drawRoundRect(100f, 100f, 500f, 400f, 200f, 150f, paint)
             it.drawRect(100f, 100f, 500f, 400f, paint)*/

        }
    }

}