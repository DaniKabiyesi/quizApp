package com.studying.quizchallenge.fragments

import android.graphics.Color
import android.graphics.Typeface
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.navigation.fragment.findNavController
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelThreeBinding

class QuizGameLevelThreeFragment : Fragment() {

    private lateinit var _binding: FragmentQuizGameLevelThreeBinding
    private val binding get() = _binding

    private var rightAnswer = 1
    private var wrongAnswer = 0

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelThreeBinding.inflate(
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
            firstButtonQuestionThree.setOnClickListener {
                showTheAnswer(wrongAnswer, firstButtonQuestionThree)
                showTheAnswer(rightAnswer, thirdButtonQuestionThree)
                goToNextScreen(false)
                showAnswerToast(false)
            }
            secondButtonQuestionThree.setOnClickListener {
                showTheAnswer(wrongAnswer, secondButtonQuestionThree)
                showTheAnswer(rightAnswer, thirdButtonQuestionThree)
                goToNextScreen(false)
                showAnswerToast(false)
            }
            thirdButtonQuestionThree.setOnClickListener {
                showTheAnswer(rightAnswer, thirdButtonQuestionThree)
                goToNextScreen(true)
                showAnswerToast(true)
            }
            fourthButtonQuestionThree.setOnClickListener {
                showTheAnswer(wrongAnswer, firstButtonQuestionThree)
                showTheAnswer(rightAnswer, thirdButtonQuestionThree)
                goToNextScreen(false)
                showAnswerToast(false)
            }
        }
    }

    private fun progressBar() {
        val currentPositionDefault = 3
        binding.progressBar.progress = currentPositionDefault
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

    private fun countdownTimeQuestion() {

        var COUNT_DOWN_TIME = 60
        val zeroTime = 0

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

    private fun goToNextScreen(gameStats: Boolean) {
        if (gameStats) {
            setNextScreen(R.id.quizGameLevelFourFragment)
        } else {
            setNextScreen(R.id.quizGameOverFragment)
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

    private fun setNextScreen(action: Int) {
        Handler().postDelayed({
            findNavController().navigate(action)
        }, 500)

    }

    private fun showAnswerToast(answerCorrect: Boolean) {
        if (answerCorrect) {
            rightAnswerToast()
        } else {
            wrongAnswerToast()
        }
    }

    private fun wrongAnswerToast() {
        Toast.makeText(
            this@QuizGameLevelThreeFragment.requireContext(),
            "Resposta incorreta!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun rightAnswerToast() {
        Toast.makeText(
            this@QuizGameLevelThreeFragment.requireContext(),
            "Resposta correta!",
            Toast.LENGTH_SHORT
        ).show()
    }
}