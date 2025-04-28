package com.example.fa22_bse_a.circle_game.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity


class GameActivity : AppCompatActivity() {

    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameView = GameScreen(this, 50f, onCircleTouchCallBack =  {
            println("Current Score  = $it")
        })
        setContentView(gameView)

//        lifecycleScope.launch {
//            while(true) {
//                delay(200)
//                gameView.drawCircleAtRandomPosition()
//            }
//        }
    }
}