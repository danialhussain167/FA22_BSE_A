package com.example.fa22_bse_a

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ImageView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class TiktakActivity : AppCompatActivity() {

    var playerTurn: Boolean = true  // true -> 1st , false -> 2nd
    val TAG: String = this@TiktakActivity.javaClass.simpleName


    val filledBoxes: MutableList<Pair<Boolean, Int>> = arrayListOf()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tiktak)
        val topLeftRef: ImageView = findViewById(R.id.topLeft_child)
        val topCenterRef: ImageView = findViewById(R.id.topCenter_child)
        val topRightRef: ImageView = findViewById(R.id.topRight_child)
        val centerLeftRef: ImageView = findViewById(R.id.centerLeft_child)
        val centerRef: ImageView = findViewById(R.id.center_child)
        val centerRightRef: ImageView = findViewById(R.id.centerRight_child)
        val bottomLeftRef: ImageView = findViewById(R.id.bottomLeft_child)
        val bottomCenterRef: ImageView = findViewById(R.id.bottomCenter_child)
        val bottomRightRef: ImageView = findViewById(R.id.bottomRight_child)

        val viewRefrences: List<ImageView> = arrayListOf(
            topLeftRef,
            topCenterRef,
            topRightRef,
            centerLeftRef,
            centerRef,
            centerRightRef,
            bottomLeftRef,
            bottomCenterRef,
            bottomRightRef
        )
        viewRefrences.forEach { viewRef ->
            viewRef.setOnClickListener {
                onViewClick(it)
            }
        }
    }

    fun onViewClick(view: View) {
        if (filledBoxes.filter { listPairItem -> listPairItem.second == view.id }.size == 0) {
            Log.e(TAG, "onViewClick: player ${if (playerTurn) 1 else 2} have clocked on ${view.id}")
            if (playerTurn) {  // player 1
                (view as ImageView).setImageDrawable(resources.getDrawable(R.drawable.baseline_tick))
            } else { // player 2
                (view as ImageView).setImageDrawable(resources.getDrawable(R.drawable.baseline_cancel_24))
            }

            filledBoxes.add(Pair(playerTurn, view.id))
            playerTurn = !playerTurn

            if (filledBoxes.size > 4) {
                checkWinner()
            }
        } else {
            Log.e(TAG, "onViewClick: This box is already filled")
        }
    }

    fun checkWinner() {
        arrayListOf(
            arrayListOf(R.id.topLeft_child, R.id.topCenter_child, R.id.topRight_child),
            arrayListOf(R.id.centerLeft_child, R.id.center_child, R.id.centerRight_child),
            arrayListOf(R.id.bottomLeft_child, R.id.bottomCenter_child, R.id.bottomRight_child)
        ).forEach { row ->
            Log.e(TAG, "checkWinner: row -> $row", )
            Log.e(TAG, "checkWinner: filled boxes ->  ${filledBoxes}", )
            if (filledBoxes.filter { stateItem -> stateItem.second == row.get(0) }
                    .getOrNull(0)?.first == true &&
                filledBoxes.filter { stateItem -> stateItem.second == row.get(1) }
                    .getOrNull(0)?.first == true &&
                filledBoxes.filter { stateItem -> stateItem.second == row.get(2) }
                    .getOrNull(0)?.first == true
            ) {
                Log.e(TAG, "checkWinner: Player 1 won the game")
                val line1 = findViewById<View>(R.id.line1_mine)
                line1.visibility = View.VISIBLE
            }
        }


    }
}