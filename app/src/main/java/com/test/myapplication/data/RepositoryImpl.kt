package com.test.myapplication.data

import com.google.gson.Gson
import com.test.myapplication.domain.QuestionsEntity
import com.test.myapplication.domain.Repository

class RepositoryImpl(
    private val service: Service,
    private val gson: Gson,
    private val mapper: Mapper
) : Repository {
//    private val questionsType = object : TypeToken<List<Questions>>() {}.type
//    private val jsonText = File("json_questions").readText()
//    private val list: List<Questions>
//        get() = gson.fromJson(jsonText, questionsType)

    override suspend fun loadQuestions(): List<QuestionsEntity> {
        // val questionsList: List<Questions> = gson.fromJson(jsonText, questionsType)
        return try {
            val response = service.loadCategory()
            if (response.isSuccessful) {
                response.body()?.map { mapper.mapDtoToEntity(it) } ?: listOf()
            } else listOf()
        } catch (e: Exception) {
            listOf()
        }


    }
}