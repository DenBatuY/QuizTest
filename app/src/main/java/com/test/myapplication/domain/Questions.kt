package com.test.myapplication.domain

data class Questions(
    val questionText: String,
    val answers: List<String>,
    val correctAnswerIndex: Int
)
