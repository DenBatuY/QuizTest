package com.test.myapplication.domain

class LoadQuestionsUseCase(private val repository: Repository) {
    suspend operator fun invoke() = repository.loadQuestions()
}