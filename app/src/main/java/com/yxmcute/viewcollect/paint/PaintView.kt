package com.yxmcute.viewcollect.paint

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View
import com.yxmcute.viewcollect.R
import kotlin.math.min

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2021/4/28 17:49
 *     desc   : STROKE的宽度是在FILL的基础上+paint.strokeWidth；FILL_AND_STROKE=FILL+STROKE
 *     link   : 所以当需要描边的时候特别注意宽度的计算
 * </pre>
 */
class PaintView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private val paint = Paint(Paint.ANTI_ALIAS_FLAG)


    init {
        attrs?.also {
            val typeArray = context.obtainStyledAttributes(it, R.styleable.PaintView)
            when (typeArray.getInt(R.styleable.PaintView_paintStyle, 0)) {
                0 -> paint.style = Paint.Style.FILL
                1 -> paint.style = Paint.Style.STROKE
                2 -> paint.style = Paint.Style.FILL_AND_STROKE
            }
            val color = typeArray.getColor(R.styleable.PaintView_paintColor, Color.BLACK)
            paint.color = color
            typeArray.recycle()
        }

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        paint.strokeWidth = 10f
        canvas?.also {
            val radius = min(measuredWidth, measuredHeight) / 4.toFloat()
            it.drawCircle(measuredWidth / 2.toFloat(), measuredHeight / 2.toFloat(), radius, paint)
        }

    }

}