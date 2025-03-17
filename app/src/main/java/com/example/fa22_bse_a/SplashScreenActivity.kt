package com.example.fa22_bse_a

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.lifecycleScope
import com.example.fa22_bse_a.basics.nested_strctures.model.Email
import com.example.fa22_bse_a.basics.nested_strctures.model.Student
import com.example.fa22_bse_a.state_managment.SystemState
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class SplashScreenActivity : AppCompatActivity() {
    val TAG = "SplashScreenActivity"

    var counterJob: Job? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)

//        val email: Email = Email("Ali123","gmail.com")

//        with(email) {
//            startActivity(Intent(this@, TiktakActivity::class.java))
//
//            Log.e(TAG, "onCreate: email = ${userName}@${domain}")
//        }



        lifecycleScope.launch {
            delay(3000)
            withContext(Dispatchers.Main) {
                startActivity(Intent(this@SplashScreenActivity, TiktakActivity::class.java))
            }
        }
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