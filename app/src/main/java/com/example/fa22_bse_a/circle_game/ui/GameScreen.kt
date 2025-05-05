package com.example.fa22_bse_a.circle_game.ui

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.view.MotionEvent
import android.view.View
import kotlin.random.Random

class GameScreen(context: Context, val radius: Float, val onCircleTouchCallBack: (Int) -> Unit) :
    View(context) {
    var cX: Float = radius
    var cY: Float = radius
    var score: Int = 0
    var colorList = arrayListOf(Color.GREEN, Color.RED, Color.BLUE, Color.YELLOW, Color.GRAY)


    fun drawCircleAtRandomPosition() {
        cX = Random.nextDouble(radius.toDouble(), (width - radius).toDouble()).toFloat()
        cY = Random.nextDouble(radius.toDouble(), (height - radius).toDouble()).toFloat()
        invalidate()
    }

    override fun onTouchEvent(event: MotionEvent?): Boolean {
        if ((event?.x ?: 0f) > cX - radius && (event?.x ?: 0f) < cX + radius && (event?.y
                ?: 0f) > cY - radius && (event?.y ?: 0f) < cY + radius
        ) {
            println("User Clicked on Circle positioned at cX = ${event?.x}, cY = ${event?.y}")
            score++
            onCircleTouchCallBack.invoke(score)
            drawCircleAtRandomPosition()
        } else {
            println("User Clicked out side of circle at cX = ${event?.x}, cY = ${event?.y}")
        }
        return super.onTouchEvent(event)
    }

    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        val paint = Paint()

        paint.color = Color.argb(
            255,
            Random.nextInt(0, 255),
            Random.nextInt(0, 255),
            Random.nextInt(0, 255)
        )    //colorList.get(Random.nextInt(0, 4))
        canvas.drawCircle(cX, cY, radius, paint)
        canvas.drawText("Score = $score", (width / 2f), 70f, Paint().apply {
            color = if (score < 5) Color.RED else Color.GREEN
            textSize = 100f
        })
    }
}