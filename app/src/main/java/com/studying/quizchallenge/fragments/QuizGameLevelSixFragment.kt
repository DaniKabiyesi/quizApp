package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelSixBinding

class QuizGameLevelSixFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelSixBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelSixBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 6)
        return binding.root
    }

    private fun setListeners() {
        binding.run {
            val correctButton = firstButtonQuestionSix
            val buttonList = listOf(
                firstButtonQuestionSix,
                secondButtonQuestionSix,
                thirdButtonQuestionSix,
                fourthButtonQuestionSix
            )
            setButtonListeners(buttonList, correctButton)
        }
    }

    override fun getNextScreenAndroid(isAnswerCorrect: Boolean): Int {
        return if (isAnswerCorrect) {
            R.id.quizGameLevelSevenFragment
        } else {
            R.id.quizGameOverFragment
        }
    }
}