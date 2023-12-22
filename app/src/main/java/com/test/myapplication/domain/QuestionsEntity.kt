package com.test.myapplication.domain

data class QuestionsEntity(
    val answers: List<String>,
    val correctAnswer: Int,
    val question: String,
    var userAnswer:Int? = null
)
