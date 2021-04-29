package com.yxmcute.viewcollect.round

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.yxmcute.viewcollect.R
import java.lang.Math.min

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2021/4/29 10:21
 *     desc   :
 *     link   :
 * </pre>
 */
class RoundBitmapViewTwo @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private val path = Path()
    private val bitmap = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_person_one,
        BitmapFactory.Options().apply {
            inJustDecodeBounds = false
            inPreferredConfig = Bitmap.Config.RGB_565
        }
    )
    private val paint = Paint()

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.also {

            val min = min(width, height)
            val src = Bitmap.createScaledBitmap(bitmap, min, min, false)
            canvas.drawBitmap(createCircleBitmap(src, min), 0f, 0f, null)



        }

    }

    private fun createCircleBitmap(source: Bitmap, min: Int): Bitmap {
        val bitmapDst = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888)
        val paint = Paint(Paint.ANTI_ALIAS_FLAG)
        val canvas = Canvas(bitmapDst)
        canvas.drawCircle(min / 2.toFloat(), min / 2.toFloat(), min / 2.toFloat(), paint)
        paint.xfermode = PorterDuffXfermode(PorterDuff.Mode.SRC_IN)// 取两层绘制交集。显示上层。
        canvas.drawBitmap(source, 0f, 0f, paint)
        return bitmapDst
    }


    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (bitmap != null && !bitmap.isRecycled) {
            bitmap.recycle()
        }
    }
}