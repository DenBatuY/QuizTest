package com.test.myapplication.presentation

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.test.myapplication.R
import com.test.myapplication.databinding.FragmentGameBinding
import com.test.myapplication.domain.QuizEntity
import com.test.myapplication.navigator
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = checkNotNull(_binding) { "FragmentGameBinding = null " }

    private val quizViewModel: MainViewModel by viewModel<MainViewModel>()
    private val buttonsList: List<TextView> by lazy {
        listOf(
            binding.tvAnswer0,
            binding.tvAnswer1,
            binding.tvAnswer2,
            binding.tvAnswer3,
            binding.tvAnswer4
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGameBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observe()
    }

    private fun observe() {
        quizViewModel.quizInfo.observe(viewLifecycleOwner) { quiz ->
            showText(quiz)
        }
    }

    private fun showText(quiz: QuizEntity) {
        Log.d("myTest", "qqq $quiz")
        val question = quiz.questions[quiz.currentIndex]
        var index = ZERO_INDEX
        buttonsList.forEach {
            it.apply {
                val ownIndex = index
                text = question.answers[index]
                setOnClickListener { quizViewModel.toAnswer(quiz.currentIndex, ownIndex) }
                if (question.userAnswer == null) {
                    setBackgroundResource(R.drawable.rounded_bg_for_answers)
                    it.isEnabled = true
                }else {
                    if (question.correctAnswerIndex == question.userAnswer && question.userAnswer == ownIndex) {
                        setBackgroundResource(R.drawable.rounded_bg_for_answers_true)
                    }
                    if (question.correctAnswerIndex != question.userAnswer && question.userAnswer == ownIndex) {
                        setBackgroundResource(R.drawable.rounded_bg_for_answers_false)
                    }
                    it.isEnabled = false
                }
            }
            index++
        }
        with(binding) {
            tvQuestion.text = question.questionText
            if (quiz.lastQuestion) btNext.text = getString(R.string.end)
            btNext.isEnabled = question.userAnswer != null
            nextQuestion(quiz)
        }
    }

    private fun nextQuestion(quiz: QuizEntity) {
        binding.btNext.setOnClickListener {
            if (!quiz.lastQuestion)
                quizViewModel.nextQuestion() else navigator().goToResultFragment(3,4)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object{
        private const val ZERO_INDEX = 0
    }
}