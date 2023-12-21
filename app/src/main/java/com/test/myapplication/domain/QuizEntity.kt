package com.test.myapplication.domain

data class QuizEntity(
    val questions:List<QuestionsEntity>,
    val countOfQuestions:Int,
    val currentIndex:Int,
    val lastQuestion:Boolean = false
)
