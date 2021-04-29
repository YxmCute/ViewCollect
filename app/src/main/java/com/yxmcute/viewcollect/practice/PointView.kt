package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yxmcute.viewcollect.globalColor

class PointView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private val paint = Paint()
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        //        练习内容：使用 canvas.drawPoint() 方法画点         一个圆点，一个方点
        //        圆点和方点的切换使用 paint.setStrokeCap(cap)：`ROUND` 是圆点，`BUTT` 或 `SQUARE` 是方点
        canvas?.also {
            paint.color = globalColor
            paint.strokeCap = Paint.Cap.ROUND
            paint.strokeWidth = 20f
            it.drawPoint(100f, 100f, paint)
            paint.strokeCap = Paint.Cap.SQUARE
            it.drawPoint(100f, 200f, paint)
            paint.strokeCap = Paint.Cap.BUTT
            it.drawPoint(100f, 300f, paint)
        }
    }

}