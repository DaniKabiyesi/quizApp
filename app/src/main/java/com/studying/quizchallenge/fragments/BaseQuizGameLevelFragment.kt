package com.studying.quizchallenge.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.CountDownTimer
import android.os.Handler
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.studying.quizchallenge.R

private const val COUNT_DOWN_TIME = 60L
private const val AMOUNT_OF_QUESTIONS = 8

abstract class BaseQuizGameLevelFragment : Fragment() {

    private lateinit var countDownTimer: CountDownTimer

    override fun onPause() {
        super.onPause()
        countDownTimer.cancel()
    }

    protected fun setButtonListeners(buttonList: List<Button>, correctButton: Button) {
        for (button in buttonList) {
            setClickButtonListener(button, correctButton)
        }

    }

    private fun setClickButtonListener(button: Button, correctButton: Button) {
        button.setOnClickListener {
            val isCorrectButton = button == correctButton
            if (!isCorrectButton) {
                showTheAnswer(Answer.WRONG_ANSWER, button)
            }
            showTheAnswer(Answer.RIGHT_ANSWER, correctButton)
            showAnswerToast(isCorrectButton)
            goToNextScreen(isAnswerCorrect = isCorrectButton)
        }
    }

    protected fun progressBar(progressBar: ProgressBar, currentPosition: Int) {
        progressBar.max = AMOUNT_OF_QUESTIONS
        progressBar.progress = currentPosition
    }

    protected fun countDownTimeQuestion(countDownTextView: TextView) {
        val zeroTime = 0
        var countDownTime = COUNT_DOWN_TIME

        countDownTimer = object : CountDownTimer(
            COUNT_DOWN_TIME * 1000,
            1000
        ) {
            override fun onTick(millisUntilFinished: Long) {
                countDownTextView.text = countDownTime.toString()
                countDownTime--
            }

            override fun onFinish() {
                countDownTextView.text = zeroTime.toString()
                goToNextScreen(isAnswerCorrect = false)
            }

        }.start()
    }

    private fun goToNextScreen(isAnswerCorrect: Boolean) {
        val actionId = getNextScreenAndroid(isAnswerCorrect)
        Handler().postDelayed({
            findNavController().navigate(actionId)
        }, 500)
    }

    private fun showTheAnswer(answer: Answer, anyButton: Button) {
        when (answer) {
            Answer.RIGHT_ANSWER -> changeTheUi(
                R.drawable.background_right_answer,
                anyButton
            )
            Answer.WRONG_ANSWER -> changeTheUi(
                R.drawable.background_wrong_answer,
                anyButton
            )
        }
    }

    private fun changeTheUi(backgroundButton: Int, anyButton: Button) {
        anyButton.setTextColor(Color.parseColor("#0d0e0f"))
        anyButton.typeface = Typeface.DEFAULT_BOLD
        anyButton.background =
            ContextCompat.getDrawable(
                this.requireContext(),
                backgroundButton
            )
    }

    private fun showAnswerToast(correctAnswer: Boolean) {
        val message = if (correctAnswer) "Resposta Correta!" else "Resposta Incorreta!"
        Toast.makeText(
            requireContext(),
            message,
            Toast.LENGTH_SHORT
        ).show()
    }

    abstract fun getNextScreenAndroid(isAnswerCorrect: Boolean): Int
}

enum class Answer {
    RIGHT_ANSWER,
    WRONG_ANSWER
}

