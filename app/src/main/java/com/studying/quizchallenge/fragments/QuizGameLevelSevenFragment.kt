package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelSevenBinding

class QuizGameLevelSevenFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelSevenBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelSevenBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 7)
        return binding.root
    }

    private fun setListeners() {
        binding.run {
            val correctButton = secondButtonQuestionSeven
            val buttonList = listOf(
                firstButtonQuestionSeven,
                secondButtonQuestionSeven,
                thirdButtonQuestionSeven,
                fourthButtonQuestionSeven
            )
            setButtonListeners(buttonList, correctButton)
        }
    }

    override fun getNextScreenAndroid(isAnswerCorrect: Boolean): Int {
        return if (isAnswerCorrect) {
            R.id.quizGameLevelFiveFragment
        } else {
            R.id.quizGameOverFragment
        }
    }
}