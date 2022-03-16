package com.studying.quizchallenge.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
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
        setListeners()

        return binding.root
    }

    private fun setListeners() {
        binding.run {
            startGameBtn.setOnClickListener {
                val message =
                    if (nicknameIsNotBlank()) {
                        goToNextScreen()
                        "Bom jogo"
                    } else {
                        "Digite seu Nickname, por favor"
                    }
                Toast.makeText(
                    requireContext(),
                    message,
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }

    private fun goToNextScreen() {
        findNavController().navigate(R.id.quizGameLevelOneFragment)
    }

    private fun nicknameIsNotBlank(): Boolean {
        binding.run {
            return nicknameEditText.text.toString().isNotBlank()
        }
    }
}