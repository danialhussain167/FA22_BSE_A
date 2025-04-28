package com.example.fa22_bse_a.circle_game.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class GameActivity : AppCompatActivity() {

    var score = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameView = GameScreen(this@GameActivity, 50f) {
            score++
            println("Current Score = $score")
        }
        setContentView(gameView)

        lifecycleScope.launch {
//            while (true) {
                delay(500)
                gameView.drawAtRandomPosition()
//            }

        }
    }
}