package com.test.myapplication.data

import com.test.myapplication.domain.QuestionsEntity
import com.test.myapplication.domain.Repository

class RepositoryImpl(
    private val service: Service,
    private val mapper: Mapper
) : Repository {

    override suspend fun loadQuestions(): List<QuestionsEntity>? {
        return try {
            val response = service.loadCategory()
            if (response.isSuccessful) {
                response.body()?.map { mapper.mapDtoToEntity(it) } ?: throw Exception()
            } else throw Exception()
        } catch (e: Exception) {
            null
        }
    }
}