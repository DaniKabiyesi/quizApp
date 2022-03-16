package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.databinding.FragmentQuizGameOverBinding

class QuizGameOverFragment : BaseQuizGameStartQuizFragment() {

    lateinit var _binding: FragmentQuizGameOverBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameOverBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners(binding.startGameBtn)
        showStartGameToast()
        return binding.root
    }

}