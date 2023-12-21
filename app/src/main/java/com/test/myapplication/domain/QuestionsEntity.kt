package com.test.myapplication.domain

data class QuestionsEntity(
    val answers: List<String>,
    val correctAnswerIndex: Int,
    val questionText: String,
    var userAnswer:Int? = null
)
