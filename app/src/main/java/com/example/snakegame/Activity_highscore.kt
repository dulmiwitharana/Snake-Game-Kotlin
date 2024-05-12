package com.example.snakegame

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class Activity_highscore : AppCompatActivity() {

    lateinit var highScoreTextView: TextView
    lateinit var sharedPreferences: SharedPreferences
    lateinit var playAgainBtn: Button
    var highScore = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_highscore)

        playAgainBtn = findViewById(R.id.imageButton)

        highScoreTextView = findViewById(R.id.highScoreTextView)


        loadHighScore()

        playAgainBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
    private fun loadHighScore() {
        val sharedPreferences = getSharedPreferences("HighScore", Context.MODE_PRIVATE)
        val highScore = sharedPreferences.getInt("HighScore", 0)
        highScoreTextView.text = "High Score: $highScore"
    }
}