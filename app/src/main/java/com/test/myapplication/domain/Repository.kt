package com.test.myapplication.domain

interface Repository {
    suspend fun loadQuestions(): List<QuestionsEntity>
}