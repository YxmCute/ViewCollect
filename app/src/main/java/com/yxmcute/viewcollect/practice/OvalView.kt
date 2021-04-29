package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.os.Build
import android.util.AttributeSet
import android.view.View
import androidx.annotation.RequiresApi
import com.yxmcute.viewcollect.globalColor

class OvalView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private val paint = Paint()

    @RequiresApi(Build.VERSION_CODES.LOLLIPOP)
    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.also {
            paint.color = Color.GRAY
            paint.style = Paint.Style.FILL
            it.drawOval(0f, 0f, 400f, 200f, paint)
            paint.style = Paint.Style.STROKE
            paint.color = globalColor
            it.drawRect(0f, 0f, 400f, 200f, paint)
        }
    }
}