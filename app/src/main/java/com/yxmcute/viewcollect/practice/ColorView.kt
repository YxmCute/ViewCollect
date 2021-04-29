package com.yxmcute.viewcollect.practice

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.util.AttributeSet
import android.view.View

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2021/4/29 15:45
 *     desc   :
 *     link   :
 * </pre>
 */
class ColorView @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.also {
            it.drawColor(Color.YELLOW)
        }
    }
}