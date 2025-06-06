package com.example.fa22_bse_a

import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_a.circle_game.ui.GameActivity
import com.example.fa22_bse_a.login.ui.LoginVBRevisedActivity
import com.example.fa22_bse_a.login_migrated.ui.LoginMigratedActivity
import com.example.fa22_bse_a.share_pref.SharedPreferenceHelper
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class SplashScreenActivity : AppCompatActivity() {
    val TAG = "SplashScreenActivity"

    var counterJob: Job? = null
    var sharedPreferenceHelper: SharedPreferenceHelper? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        lifecycleScope.launch {
            delay(2000)
            if(sharedPreferenceHelper?.getData("IsLoggedIn") == "YES"){
                startActivity(Intent(this@SplashScreenActivity, GameActivity::class.java))
            } else {
                startActivity(Intent(this@SplashScreenActivity, LoginMigratedActivity::class.java))
            }
            finish()
        }

//        val imageRef: ImageView = findViewById(R.id.imageeeee)
//        imageRef.setOnClickListener {
//            val intent: Intent = Intent(this,SignUpActivity::class.java).putExtra("abc","ABCDEF")
//            startActivity(intent)
//        }


//        val email: Email = Email("Ali123","gmail.com")

//        with(email) {
//            startActivity(Intent(this@, TiktakActivity::class.java))
//
//            Log.e(TAG, "onCreate: email = ${userName}@${domain}")
//        }


//        lifecycleScope.launch {
//            delay(3000)
//            withContext(Dispatchers.Main) {
//                startActivity(Intent(this@SplashScreenActivity, TiktakActivity::class.java))
//            }
//        }
    }

    override fun onResume() {
        super.onResume()
        val counterRef: TextView = findViewById(R.id.counter)

//        counterJob = lifecycleScope.launch {
//            while (true) {
//                delay(200)
//                SystemState.countState = SystemState.countState + 1
//                withContext(Dispatchers.Main) {
//                    counterRef.setText(SystemState.countState.toString())
//                }
//            }
//        }
    }

    override fun onPause() {
        super.onPause()
//        counterJob?.cancel()
    }
}