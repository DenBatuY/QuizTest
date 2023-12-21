package com.test.myapplication.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myapplication.domain.LoadQuestionsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadQuestionsUseCase: LoadQuestionsUseCase
) : ViewModel() {

    fun loadQuestion() {
        viewModelScope.launch(Dispatchers.IO) {
            loadQuestionsUseCase()
        }
    }
}