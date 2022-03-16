package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelThreeBinding

class QuizGameLevelThreeFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelThreeBinding
    private val binding get() = _binding

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
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 3)
        return binding.root
    }

    private fun setListeners() {

        binding.run {
            val correctButton = thirdButtonQuestionThree
            val buttonList = listOf(
                firstButtonQuestionThree,
                secondButtonQuestionThree,
                thirdButtonQuestionThree,
                fourthButtonQuestionThree
            )
            setButtonListeners(buttonList, correctButton)
        }
    }

    override fun getNextScreenAndroid(isAnswerCorrect: Boolean): Int {
        return if (isAnswerCorrect) {
            R.id.quizGameLevelFourFragment
        } else {
            R.id.quizGameOverFragment
        }
    }
}

