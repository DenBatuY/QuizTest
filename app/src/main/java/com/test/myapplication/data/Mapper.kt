package com.test.myapplication.data

import com.test.myapplication.domain.QuestionsEntity

class Mapper {
    fun mapDtoToEntity(dto: QuestionsDto): QuestionsEntity {
        return QuestionsEntity(
            answers = dto.answers,
            correctAnswer = dto.correctAnswer,
            question = dto.question
        )
    }
}