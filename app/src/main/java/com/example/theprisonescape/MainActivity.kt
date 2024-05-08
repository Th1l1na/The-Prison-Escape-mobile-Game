package com.example.theprisonescape

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    lateinit var tv_highscore: TextView
    private lateinit var highScoreViewModel: HighScoreViewModel
    private lateinit var main_audio: MediaPlayer

//    private lateinit var viewModel: HighScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        viewModel = ViewModelProvider(this, ViewModelProvider.AndroidViewModelFactory.getInstance(application)).get(HighScoreViewModel::class.java)

        highScoreViewModel = HighScoreViewModel(applicationContext)

        main_audio = MediaPlayer.create(this, R.raw.main_audio)

        tv_highscore = findViewById(R.id.tv_highscore)

        // Start background music
        main_audio.isLooping = true
        main_audio.start()

//        viewModel.highScore.observe(this, Observer { highScore ->
//            tv_highscore.text = "Highscr: $highScore"
//        })

        highScoreViewModel.highScore.observe(this) { highScore ->
            // Update your UI element (e.g., TextView) with the high score
            tv_highscore.text = "High Score: $highScore"
        }

        val startButton: ImageButton = findViewById(R.id.start_game_button)

        startButton.setOnClickListener {
            val Intent = Intent(this, GameplayActivity::class.java)
            startActivity(Intent)
            main_audio.release()
        }

    }

    override fun onResume() {
        super.onResume()
        // Reload high score when MainActivity is resumed
        highScoreViewModel.loadHighScore()
    }

}