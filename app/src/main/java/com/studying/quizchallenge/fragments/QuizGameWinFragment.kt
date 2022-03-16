package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.studying.quizchallenge.databinding.FragmentQuizGameWinBinding


class QuizGameWinFragment : BaseQuizGameStartQuizFragment() {

    lateinit var _binding: FragmentQuizGameWinBinding
    private val binding get() = _binding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentQuizGameWinBinding.inflate(
            inflater,
            container,
            false
        )
        setListeners(binding.startGameBtn)
        showStartGameToast()
        return binding.root
    }


}