package com.test.myapplication.presentation

import android.app.Application
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.myapplication.R
import com.test.myapplication.domain.LoadQuestionsUseCase
import com.test.myapplication.domain.QuestionsEntity
import com.test.myapplication.domain.QuizEntity
import kotlinx.coroutines.launch

class MainViewModel(
    private val loadQuestionsUseCase: LoadQuestionsUseCase,
    private val context: Application,
    private val gson: Gson
) : ViewModel() {

    private var _score = ZERO_COUNT
    private val _loading = MutableLiveData(true)
    val loading: LiveData<Boolean>
        get() = _loading
    val score: Int
        get() = _score

    init {
        loadQuestion()
    }

    private val _quizInfo = MutableLiveData<QuizEntity>()
    val quizInfo: LiveData<QuizEntity>
        get() = _quizInfo

    private fun loadQuestion() {
        viewModelScope.launch {
            _loading.value = true
            val request = loadQuestionsUseCase()?:getJson()
            val quiz = QuizEntity(
                questions = request,
                countOfQuestions = request.size,
                currentIndex = ZERO_INDEX
            )
            _quizInfo.value = quiz
            _loading.value = false
        }
    }

    private fun getJson(): List<QuestionsEntity> {
        val inputStream = context.resources.openRawResource(R.raw.json_questions)
        val jsonText = inputStream.bufferedReader().use { it.readText() }
        val questionsType = object : TypeToken<List<QuestionsEntity>>() {}.type
        return gson.fromJson(jsonText, questionsType)
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

    fun increaseScore() {
        ++_score
    }

    companion object {
        private const val ZERO_INDEX = 0
        private const val ZERO_COUNT = 0
    }
}