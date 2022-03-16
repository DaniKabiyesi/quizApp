package com.studying.quizchallenge.fragments

import android.widget.Button
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.studying.quizchallenge.R

abstract class BaseQuizGameStartQuizFragment : Fragment() {


    protected fun setListeners(button: Button) {
        button.setOnClickListener {
            goToFirstQuestion()
        }
    }

    private fun goToFirstQuestion() {
        findNavController().popBackStack(
            R.id.quizGameLevelOneFragment,
            false
        )

    }

    protected fun showStartGameToast() {
        val startGameMessage = "Bom jogo!"
        Toast.makeText(
            requireContext(), startGameMessage,
            Toast.LENGTH_SHORT
        ).show()

    }
}