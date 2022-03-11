package com.studying.quizchallenge

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import com.studying.quizchallenge.databinding.ActivityQuickDisplayBinding

class QuickDisplayActivity : AppCompatActivity() {

    lateinit var binding: ActivityQuickDisplayBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuickDisplayBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        startNicknameQuiz()
    }

    private fun startNicknameQuiz() {
        goToNextScreen()

    }

    private fun goToNextScreen() {
        Handler().postDelayed({
            setNextScreen()
            finish()
        }, 1600)
    }

    private fun setNextScreen() {
        val intent = Intent(
            this@QuickDisplayActivity,
            QuizGameActivity::class.java
        )
        startActivity(intent)
    }
}