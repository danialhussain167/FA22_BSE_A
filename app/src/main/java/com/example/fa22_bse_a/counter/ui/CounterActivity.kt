package com.example.fa22_bse_a.counter.ui

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.fa22_bse_a.R
import com.example.fa22_bse_a.counter.model.CounterModel

class CounterActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_counter)

        val countTV: TextView = findViewById(R.id.counter_tv)
        val countBtn: Button = findViewById(R.id.count_btn)
        val resetBtn: ImageView = findViewById(R.id.reset_count)

        val countModel:CounterModel = CounterModel()
        countBtn.setOnClickListener {
            countModel.counter = countModel.counter + 1
            countTV.setText(countModel.counter.toString())
        }

        resetBtn.setOnClickListener {
            countModel.counter = 0
            countTV.setText(countModel.counter.toString())
        }



    }
}