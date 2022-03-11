package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.os.Handler
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameWinBinding


class QuizGameWinFragment : Fragment() {

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
        goBackToTheGame()
        return binding.root
    }

    private fun goBackToTheGame() {
        binding.run {
            startGameBtn.setOnClickListener {
                firstScreen()
                startGameToast()
            }
        }
    }

    private fun startGameToast() {
        Toast.makeText(
            this@QuizGameWinFragment.requireContext(),
            "Bom jogo!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun firstScreen() {
        Handler().postDelayed({
            findNavController().navigate(R.id.quizGameLevelOneFragment)
        }, 500)
    }
}