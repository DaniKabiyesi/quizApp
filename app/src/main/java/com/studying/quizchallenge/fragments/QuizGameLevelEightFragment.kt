package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelEightBinding

class QuizGameLevelEightFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelEightBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelEightBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 8)
        return binding.root
    }

    private fun setListeners() {
        binding.run {
            val correctButton = firstButtonQuestionEight
            val buttonList = listOf(
                firstButtonQuestionEight,
                secondButtonQuestionEight,
                thirdButtonQuestionEight,
                fourthButtonQuestionEight
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
