package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameLevelFourBinding

class QuizGameLevelFourFragment : BaseQuizGameLevelFragment() {

    private lateinit var _binding: FragmentQuizGameLevelFourBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameLevelFourBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners()
        countDownTimeQuestion(binding.countDownTextView)
        progressBar(binding.progressBar, 4)
        return binding.root
    }


    private fun setListeners() {
        binding.run {
            val correctButton = fourthButtonQuestionFour
            val buttonList = listOf(
                firstButtonQuestionFour,
                secondButtonQuestionFour,
                thirdButtonQuestionFour,
                fourthButtonQuestionFour
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
