package com.test.myapplication.data

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class QuestionsDto(
    @SerialName("answers")
    val answers: List<String>,
    @SerialName("correctAnswer")
    val correctAnswer: Int,
    @SerialName("question")
    val question: String
)
