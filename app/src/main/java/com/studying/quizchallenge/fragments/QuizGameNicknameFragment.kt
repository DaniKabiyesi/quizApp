package com.studying.quizchallenge.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.studying.quizchallenge.R
import com.studying.quizchallenge.databinding.FragmentQuizGameNicknameBinding

class QuizGameNicknameFragment : Fragment() {

    private lateinit var _binding: FragmentQuizGameNicknameBinding
    private val binding get() = _binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentQuizGameNicknameBinding.inflate(
            inflater,
            container,
            false
        )
        goPlayQuiz()
        return binding.root
    }

    private fun goPlayQuiz() {
        binding.run {
            startGameBtn.setOnClickListener {

                if (nicknameIsBlank()) {
                    goToNextScreen()
                    showStartGameToast()

                } else {
                    showTypeNicknameToast()
                }
            }
        }
    }

    private fun goToNextScreen() {
        findNavController().navigate(R.id.quizGameLevelOneFragment)
    }

    private fun showTypeNicknameToast() {
        Toast.makeText(
            this@QuizGameNicknameFragment.requireActivity(),
            "Digite seu nickname, por favor",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun showStartGameToast() {
        Toast.makeText(
            this@QuizGameNicknameFragment.requireContext(),
            "Bom jogo!",
            Toast.LENGTH_SHORT
        ).show()
    }

    private fun nicknameIsBlank(): Boolean {
        return binding.nicknameEditText.text.toString().isNotBlank()
    }

}