package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelTwoBinding


class QuizGameLevelTwoFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelTwoBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelTwoBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 2)
        return binding.root
    }

    private fun setListeners() {
        binding.run {
            val correctButton = thirdButtonQuestionTwo
            val buttonList = listOf(
                firstButtonQuestionTwo,
                secondButtonQuestionTwo,
                thirdButtonQuestionTwo,
                fourthButtonQuestionTwo
            )
            setButtonListeners(buttonList, correctButton)
        }
    }

    override fun getNextScreenAndroid(isAnswerCorrect: Boolean): Int {
        return if (isAnswerCorrect) {
            R.id.quizGameLevelThreeFragment
        } else {
            R.id.quizGameOverFragment
        }
    }

}