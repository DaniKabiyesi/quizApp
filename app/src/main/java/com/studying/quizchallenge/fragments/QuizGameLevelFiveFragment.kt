package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelFiveBinding

class QuizGameLevelFiveFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelFiveBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelFiveBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 5)
        return binding.root
    }

    private fun setListeners() {
        binding.run {
            val correctButton = thirdButtonQuestionFive
            val buttonList = listOf(
                firstButtonQuestionFive,
                secondButtonQuestionFive,
                thirdButtonQuestionFive,
                fourthButtonQuestionFive
            )
            setButtonListeners(buttonList, correctButton)
        }
    }

    override fun getNextScreenAndroid(isAnswerCorrect: Boolean): Int {
        return if (isAnswerCorrect) {
            R.id.quizGameLevelSixFragment
        } else {
            R.id.quizGameOverFragment
        }
    }
}