package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelOneBinding


class QuizGameLevelOneFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelOneBinding
    private val binding get() = _binding

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
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 1)
        return binding.root
    }

    private fun setListeners() {

        binding.run {
            val correctButton = secondButtonQuestionOne
            val buttonList = listOf(
                firstButtonQuestionOne,
                secondButtonQuestionOne,
                thirdButtonQuestionOne,
                fourthButtonQuestionOne
            )
            setButtonListeners(buttonList, correctButton)
        }
    }

    override fun getNextScreenAndroid(isAnswerCorrect: Boolean): Int {
        return if (isAnswerCorrect) {
            R.id.quizGameLevelTwoFragment
        } else {
            R.id.quizGameOverFragment
        }
    }


}

