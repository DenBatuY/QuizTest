package com.test.myapplication.domain

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Questions(
    @SerialName("answers")
    val answers: List<String>,
    @SerialName("correctAnswer")
    val correctAnswerIndex: Int,
    @SerialName("question")
    val questionText: String
)
