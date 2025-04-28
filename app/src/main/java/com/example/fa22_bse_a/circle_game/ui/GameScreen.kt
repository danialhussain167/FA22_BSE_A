package com.example.fa22_bse_a.circle_game.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class GameScreen(context: Context, val r: Float, val circleClickCallBack:()->Unit) : View(context) {
    val paint = Paint()
    var cX: Float = r
    var cY: Float = r


    fun drawAtRandomPosition() {
        cX = Random.nextDouble(this.r.toDouble() + 50, width.toDouble() - r).toFloat()
        cY =
            Random.nextDouble(r.toDouble() + 50, height.toDouble() - r).toFloat()
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if ((event?.x ?: 0f) > (cX - 100f) && (event?.x ?: 0f) < (cX + 100f) && (event?.y
                ?: 0f) > (cY - 100f) && (event?.y ?: 0f) < (cY + 100f)
        ) {
            circleClickCallBack.invoke()
            drawAtRandomPosition()
            println(" Touch is on the circle at x = ${(event?.x ?: 0f)} , y = ${(event?.y ?: 0f)}")
        } else {
            println("x = ${(event?.x ?: 0f)} , y = ${(event?.y ?: 0f)}")

        }

        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        paint.color = Color.GREEN
        canvas.drawCircle(cX, cY, r, paint)
    }
}