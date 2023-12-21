package com.test.myapplication.data

import com.test.myapplication.domain.QuestionsEntity

class Mapper {
    fun mapDtoToEntity(dto: QuestionsDto): QuestionsEntity {
        return QuestionsEntity(
            answers = dto.answers,
            correctAnswerIndex = dto.correctAnswerIndex,
            questionText = dto.questionText
        )
    }
}