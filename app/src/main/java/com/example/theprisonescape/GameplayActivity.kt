package com.example.theprisonescape

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.ImageButton
import android.widget.TextView
import kotlin.random.Random

class GameplayActivity : AppCompatActivity() {
    private lateinit var highScoreViewModel: HighScoreViewModel

    private var isPressed = false
    private lateinit var mediaPlayer: MediaPlayer
    private lateinit var back_music: MediaPlayer
    private lateinit var door_open: MediaPlayer

    lateinit var tv_click: TextView
    lateinit var tv_time: TextView
    lateinit var bt_click: ImageButton
    lateinit var bt_start: ImageButton

    var curruntTime = 40
    private lateinit var timer: CountDownTimer
    private lateinit var tv_score: TextView
    private var score = 0
    private lateinit var sharedPreferences: SharedPreferences
    private var isButtonClickable = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameplay)

        val highScoreViewModel = HighScoreViewModel(applicationContext)

        sharedPreferences = getSharedPreferences("MyPref", Context.MODE_PRIVATE)

        mediaPlayer = MediaPlayer.create(this, R.raw.mine)
        back_music = MediaPlayer.create(this, R.raw.back_music)
        door_open = MediaPlayer.create(this, R.raw.door)


        tv_score = findViewById(R.id.tv_score)
        tv_click = findViewById(R.id.tv_click)
        tv_time = findViewById(R.id.tv_time)
        bt_click = findViewById(R.id.bt_click)
        bt_start = findViewById(R.id.bt_start)

        bt_click.isEnabled = false

        // Start background music
        back_music.isLooping = true
        back_music.start()

        tv_score.text = "How to play:"
        tv_click.text = "start & click on ⛏ to find a wayout!!! If you cought you loose 5 points"

        bt_start.setOnClickListener {
            curruntTime = 40

            tv_time.text = "Time: $curruntTime"
            bt_start.isEnabled = false
            bt_click.isEnabled = true
            bt_start.visibility = View.INVISIBLE
            timer.start()

            tv_click.text = "Escape Before time goes down"
        }

        bt_click.setOnClickListener {
            if (isButtonClickable) {

                back_music.pause()
                openDoor()

                if (!bt_click.isEnabled) return@setOnClickListener // Button already disabled
                if (curruntTime > 0) {
                    if (isButtonClickable) {
                        score -= 5
                        tv_score.text = "Hits: $score"
                        isButtonClickable = false
                        bt_click.isEnabled = false

                        // Re-enable the button after one second
                        bt_click.postDelayed({
                            isButtonClickable = true
                            bt_click.isEnabled = true
                        }, 100)
                    }
                }
            } else {

                back_music.start()

                score += 1
                tv_score.text = "Hits: $score"
            }
            if (isPressed) {
//                bt_click.setBackgroundResource(R.drawable.start)
            } else {
//                bt_click.setBackgroundResource(R.drawable.mine_down_rm1)
            }
            isPressed = !isPressed // Reverse the state
            playSound()
        }


        timer = object : CountDownTimer(40000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                curruntTime--
                tv_time.text = "Time: $curruntTime"

                // Check if the button should be clickable
                if (curruntTime % 5 == 0) { // Change every 5 seconds
                    isButtonClickable = Random.nextBoolean()
                    if (isButtonClickable) {
//                        bt_click.text = "Not Clickable"
                        tv_click.text = "Shhh!!! Some one's watching you..."
//                        bt_click.isEnabled = true
                    } else {
                        tv_click.text = "Okay.. He went."
//                        bt_click.text = "Clickable"
//                        bt_click.isEnabled = false
                    }
                }
            }

            override fun onFinish() {
                tv_time.text = "Time: 0"
                bt_start.isEnabled = true
                bt_click.isEnabled = false
                bt_start.visibility = View.VISIBLE

                val highScore = sharedPreferences.getInt("highScore", 0)
                if (score > highScore) {
                    // Navigate to new screen with final score
                    val intent = Intent(this@GameplayActivity, FinalScoreActivity::class.java)
                    intent.putExtra("finalScore", score)
                    startActivity(intent)
                }
                else{
                    tv_click.text = "You coudn't Escape. Better luck next time!!!"
                }

                highScoreViewModel.updateHighScore(score)
            }
        }

    }

    private fun playSound() {
        if (!mediaPlayer.isPlaying) {
            mediaPlayer.start() // Start playing the sound
        } else {
            mediaPlayer.seekTo(0) // Rewind to the beginning
        }
    }

    private fun openDoor() {
        if (!mediaPlayer.isPlaying) {
            door_open.start() // Start playing the sound
        } else {
            door_open.seekTo(0) // Rewind to the beginning
        }
    }

    // Release media player resources when activity is destroyed
    override fun onDestroy() {
        super.onDestroy()
        back_music.release()
    }

}