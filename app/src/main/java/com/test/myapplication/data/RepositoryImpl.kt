package com.test.myapplication.data

import com.test.myapplication.domain.Questions
import com.test.myapplication.domain.Repository

class RepositoryImpl(private val service: Service) : Repository {

    override suspend fun loadQuestions(): List<Questions> {
        TODO("Not yet implemented")
    }
}