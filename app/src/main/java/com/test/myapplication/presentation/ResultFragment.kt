package com.test.myapplication.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.test.myapplication.databinding.FragmentResultBinding
import com.test.myapplication.navigator

class ResultFragment : Fragment() {
    private var _binding: FragmentResultBinding? = null
    private val binding: FragmentResultBinding
        get() = checkNotNull(_binding) { "FragmentResultBinding = null " }
    private val allCount: Int?
        get() = arguments?.getInt(ALL_QUESTION_COUNT_KEY)
    private val scoreCount: Int?
        get() = arguments?.getInt(SCORE_KEY)

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
        initiate()
        tryAgain()
    }

    private fun initiate() {
        binding.tvAnswersCount.text = allCount.toString()
        binding.tvRightAnswersCount.text = scoreCount.toString()
    }

    private fun tryAgain(){
        binding.btTryAgain.setOnClickListener {
            navigator().goToGameFragment()
        }
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
                    putInt(ALL_QUESTION_COUNT_KEY, allQuestionCount)
                    putInt(SCORE_KEY, score)
                }
            }
    }
}