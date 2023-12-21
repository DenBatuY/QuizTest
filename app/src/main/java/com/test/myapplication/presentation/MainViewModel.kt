package com.test.myapplication.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.test.myapplication.domain.LoadQuestionsUseCase
import com.test.myapplication.domain.QuizEntity
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadQuestionsUseCase: LoadQuestionsUseCase
) : ViewModel() {

    init {
        loadQuestion()
    }

    private val _quizInfo = MutableLiveData<QuizEntity>()
    val quizInfo: LiveData<QuizEntity>
        get() = _quizInfo

    private fun loadQuestion() {
        viewModelScope.launch {
            val request = loadQuestionsUseCase()
            val quiz = QuizEntity(
                questions = request,
                countOfQuestions = request.size,
                currentIndex = ZERO_INDEX
            )
            _quizInfo.value = quiz
        }
    }

    fun nextQuestion() {
        val quiz = _quizInfo.value ?: return
        val currentIndex = quiz.currentIndex
        if ((quiz.countOfQuestions - 1) != currentIndex) {
            _quizInfo.value = quiz.copy(currentIndex = currentIndex.plus(1))
        } else {
            _quizInfo.value = quiz.copy(lastQuestion = true)
        }
    }

    fun toAnswer(questionId: Int, answerId: Int) {
        val quiz = _quizInfo.value ?: return
        quiz.questions[questionId].userAnswer = answerId
        _quizInfo.value = quiz
    }

    companion object {
        private const val ZERO_INDEX = 0
    }
}