package com.test.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.myapplication.R
import com.test.myapplication.databinding.FragmentGameBinding
import com.test.myapplication.databinding.FragmentResultBinding

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = checkNotNull(_binding) { "FragmentResultBinding = null " }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private const val SCORE_KEY = "score key"
        private const val ALL_QUESTION_COUNT_KEY = "allQuestionCount key"

        fun newInstance(score: Int, allQuestionCount: Int) =
            ResultFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}