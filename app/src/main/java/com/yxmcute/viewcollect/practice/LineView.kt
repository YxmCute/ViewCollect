package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yxmcute.viewcollect.globalColor

class LineView @JvmOverloads constructor(
    context: Context, attrs: AttributeSet? = null, defStyleAttr: Int = 0
) : View(context, attrs, defStyleAttr) {
    private val paint = Paint().apply {
        color = globalColor
        strokeWidth = 5f
    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.also {
            //由于直线不是封闭图形，所以 setStyle(style) 对直线没有影响。
            it.translate(width / 2.toFloat(), height / 2.toFloat())
            it.drawLine(0f, 0f, 100f, 0f, paint)
            it.drawLine(50f, 0f, 50f, 100f, paint)
            it.drawLine(0f, 100f, 100f, 100f, paint)

            it.drawLine(150f, 0f, 250f, 0f, paint)
            it.drawLine(150f, 0f, 150f, 100f, paint)
            it.drawLine(150f, 100f, 250f, 100f, paint)
            it.drawLine(250f, 100f, 250f, 0f, paint)
            it.translate(-width / 2.toFloat(), -height / 2.toFloat())
            val points = floatArrayOf(
                20f,
                20f,
                120f,
                20f,
                70f,
                20f,
                70f,
                120f,
                20f,
                120f,
                120f,
                120f,
                150f,
                20f,
                250f,
                20f,
                150f,
                20f,
                150f,
                120f,
                250f,
                20f,
                250f,
                120f,
                150f,
                120f,
                250f,
                120f
            );
            canvas.drawLines(points, paint)
            it.translate(width / 2.toFloat(), 0f)
            //offset 表示跳过数组的前几个数再开始记坐标；count 表示一共要绘制几个点,线的数量=count>>2,所以会绘制24>>2 =6条线
            canvas.drawLines(points, 4, points.size - 4, paint)

        }
    }
}