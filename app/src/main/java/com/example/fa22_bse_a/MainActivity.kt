package com.example.fa22_bse_a

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.student_card_activity)

        val studentCardRef: CardView = findViewById(R.id.student_card)

        val rotationJob = GlobalScope.launch {
            while(true) {
                for (angle in 0..360) {
                    studentCardRef.rotation = angle.toFloat()
                    delay(30)
                }
            }
        }


    }
}