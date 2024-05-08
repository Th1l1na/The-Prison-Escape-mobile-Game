package com.example.theprisonescape

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class HighScoreViewModel(private val context: Context) : ViewModel() {

    var curruntClicks = 0

    private val _highscore = MutableLiveData<Int>()
    val highScore: LiveData<Int>
        get() = _highscore

    init {
        _highscore.value = getHighScoreFromPreferences()
    }

    fun clickCurrent(){
        curruntClicks++;
    }

    fun updateHighScore(score: Int)  {

        if (score > (_highscore.value ?: 0)){
            _highscore.value = score
            saveHighScore(score)
        }
    }

    fun loadHighScore() {
        _highscore.value = getHighScoreFromPreferences()
    }

    private fun saveHighScore(highScore: Int){
        val sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        val editor = sharedPreferences.edit()
        editor.putInt("highScore", highScore)
        editor.apply()
    }

    private fun getHighScoreFromPreferences(): Int {
        val sharedPreferences = context.getSharedPreferences("MyPref", Context.MODE_PRIVATE)
        return sharedPreferences.getInt("highScore", 0)
    }


}