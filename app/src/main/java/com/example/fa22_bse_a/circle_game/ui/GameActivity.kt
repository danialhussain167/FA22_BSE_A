package com.example.fa22_bse_a.circle_game.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.fa22_bse_a.login.ui.LoginVBRevisedActivity
import com.example.fa22_bse_a.share_pref.SharedPreferenceHelper


class GameActivity : AppCompatActivity() {

    var score = 0
    var sharedPreferenceHelper: SharedPreferenceHelper? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val gameView = GameScreen(this, 50f, onCircleTouchCallBack =  {
            println("Current Score  = $it")
            if(it > 5) {
                sharedPreferenceHelper?.saveData("IsLoggedIn", "No")
                startActivity(Intent(this, LoginVBRevisedActivity::class.java))
            }
        })
        setContentView(gameView)
        sharedPreferenceHelper = SharedPreferenceHelper(this)

//        lifecycleScope.launch {
//            while(true) {
//                delay(200)
//                gameView.drawCircleAtRandomPosition()
//            }
//        }
    }
}