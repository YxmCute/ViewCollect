package com.yxmcute.viewcollect.round

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import com.yxmcute.viewcollect.R

/**
 * <pre>
 *     author : LiJun
 *     e-mail : lijunyxm@qq.com
 *     time   : 2021/4/29 10:21
 *     desc   : 裁剪一个圆角View，边缘锯齿无法消除
 *     link   :
 * </pre>
 */
class RoundBitmapViewOne @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) :
    View(context, attrs, defStyleAttr) {
    private val path = Path()
    private val bitmap = BitmapFactory.decodeResource(
        context.resources,
        R.drawable.ic_person,
        BitmapFactory.Options().apply {
            inJustDecodeBounds = false
            inPreferredConfig = Bitmap.Config.RGB_565
        }
    )
    private val paint = Paint()

    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.also {
            //移动到坐标原点到View的中心
            it.translate(width / 2.toFloat(), height / 2.toFloat())
            //添加一个半径大小为100像素的圆并裁剪画布
            path.addCircle(0f, 0f, 100f, Path.Direction.CW)
            it.drawFilter =
                PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG or Paint.FILTER_BITMAP_FLAG)
            it.clipPath(path)
            // 指定图片绘制区域(全部)
            val rectSrc = Rect(0, 0, bitmap.width, bitmap.height)
            //指定图片在屏幕上的显示区域 200像素的正方形
            val rectDst = Rect(-100, -100, 100, 100)
            paint.isAntiAlias = true
            paint.isFilterBitmap = true
            paint.isDither = true
            it.drawBitmap(bitmap, rectSrc, rectDst, paint)

        }

    }

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        if (bitmap != null && !bitmap.isRecycled) {
            bitmap.recycle()
        }
    }
}