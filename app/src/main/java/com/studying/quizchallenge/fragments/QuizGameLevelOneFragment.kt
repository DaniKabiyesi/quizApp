package com.studying.quizchallenge.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelOneBinding


class QuizGameLevelOneFragment : Fragment() {

    private lateinit var _binding: FragmentQuizGameLevelOneBinding
    private val binding get() = _binding

    private var rightAnswer = 1
    private var wrongAnswer = 0


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelOneBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()
        countdownTimeQuestion()
        progressBar()
        return binding.root
    }

    private fun setListeners() {

        binding.run {
            firstButtonQuestionOne.setOnClickListener {
                showTheAnswer(wrongAnswer, firstButtonQuestionOne)
                showTheAnswer(rightAnswer, secondButtonQuestionOne)
                goToNextScreen(false)
                showAnswerToast(false)
            }
            secondButtonQuestionOne.setOnClickListener {
                showTheAnswer(rightAnswer, secondButtonQuestionOne)
                goToNextScreen(true)
                showAnswerToast(true)
            }
            thirdButtonQuestionOne.setOnClickListener {
                showTheAnswer(wrongAnswer, thirdButtonQuestionOne)
                showTheAnswer(rightAnswer, secondButtonQuestionOne)
                goToNextScreen(false)
                showAnswerToast(false)
            }
            fourthButtonQuestionOne.setOnClickListener {
                showTheAnswer(wrongAnswer, fourthButtonQuestionOne)
                showTheAnswer(rightAnswer, secondButtonQuestionOne)
                goToNextScreen(false)
                showAnswerToast(false)
            }
        }
    }

    private fun progressBar() {
        val currentPositionDefault = 1
        binding.progressBar.progress = currentPositionDefault
    }

    private fun countdownTimeQuestion() {

        val zeroTime = 0
        var COUNT_DOWN_TIME = 60

        object : CountDownTimer(60000, 1000) {

            override fun onTick(millisUntilFinished: Long) {
                binding.countDownTextView.text = COUNT_DOWN_TIME.toString()
                COUNT_DOWN_TIME--

            }

            override fun onFinish() {
                binding.countDownTextView.text = zeroTime.toString()
                goToNextScreen(false)
            }
        }.start()

    }

    private fun showTheAnswer(answer: Int, anyButton: Button) {

        when (answer) {
            rightAnswer -> {
                changeTheUi(R.drawable.background_right_answer, anyButton)
            }
            wrongAnswer -> {
                changeTheUi(R.drawable.background_wrong_answer, anyButton)
            }
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

    private fun goToNextScreen(gameStats: Boolean) {

        if (gameStats) {
            setNextScreen(R.id.quizGameLevelTwoFragment)
        } else {
            setNextScreen(R.id.quizGameOverFragment)

        }
    }

    private fun setNextScreen(action: Int) {
        Handler().postDelayed({
            findNavController().navigate(action)
        }, 500)

    }

    private fun showAnswerToast(correctAnswer: Boolean) {
        if (correctAnswer) {
            rightAnswerToast()

        } else {
            wrongAnswerToast()
        }
    }

    private fun wrongAnswerToast() {
        Toast.makeText(
            this@QuizGameLevelOneFragment.requireContext(),
            "Resposta incorreta!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun rightAnswerToast() {
        Toast.makeText(
            this@QuizGameLevelOneFragment.requireContext(),
            "Resposta correta!",
            Toast.LENGTH_SHORT
        ).show()
    }


}
