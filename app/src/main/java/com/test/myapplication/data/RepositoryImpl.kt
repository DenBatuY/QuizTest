package com.test.myapplication.data

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.test.myapplication.R
import com.test.myapplication.domain.Questions
import com.test.myapplication.domain.Repository
import java.io.File

class RepositoryImpl(private val service: Service, private val gson: Gson) : Repository {
    private val questionsType = object : TypeToken<List<Questions>>() {}.type
    private val jsonText = File("json_questions").readText()
    private val list: List<Questions>
        get() = gson.fromJson(jsonText, questionsType)

    override suspend fun loadQuestions(): List<Questions> {
        val questionsList: List<Questions> = gson.fromJson(jsonText, questionsType)
        return try {
            val response = service.loadCategory()
            return if (response.isSuccessful)
                response.body() ?: listOf() else listOf()
        } catch (e: Exception) {
            listOf()
        }


    }
}