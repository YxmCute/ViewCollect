package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

//练习内容：使用 canvas.drawCircle() 方法画圆
//        一共四个圆：1.实心圆 2.空心圆 3.蓝色实心圆 4.线宽为 20 的空心圆
class DrawCircleView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet?,
    defStyleAttr: Int
) :
    View(context, attrs, defStyleAttr) {

    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)

        canvas?.also {
            paint.style = Paint.Style.FILL
            paint.color = Color.GRAY
            it.translate(width / 2.toFloat(), height / 2.toFloat())
            it.drawCircle(0f, 0f, 40f, paint)//1
            paint.strokeWidth = 0f
            paint.color = Color.RED
            paint.style = Paint.Style.STROKE
            it.drawCircle(0f, 0f, 60f, paint)//2
            it.translate(0f, 120f)
            paint.style = Paint.Style.FILL
            paint.color = Color.BLUE
            it.drawCircle(0f, 0f, 60f, paint)//3
            paint.color = Color.LTGRAY
            paint.style = Paint.Style.STROKE
            paint.strokeWidth = 20f
            it.translate(0f, 120f + 10f)
            it.drawCircle(0f, 0f, 60f, paint)//4


        }
    }

}