package com.test.myapplication.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.test.myapplication.R
import com.test.myapplication.databinding.FragmentGameBinding
import com.test.myapplication.databinding.FragmentWelcomBinding
import org.koin.androidx.viewmodel.ext.android.viewModel

class GameFragment : Fragment() {

    private var _binding: FragmentGameBinding? = null
    private val binding: FragmentGameBinding
        get() = checkNotNull(_binding) { "FragmentGameBinding = null " }

    private val quizViewModel: MainViewModel by viewModel<MainViewModel>()

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
        quizViewModel.loadQuestion()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}