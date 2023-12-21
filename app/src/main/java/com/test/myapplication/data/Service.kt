package com.test.myapplication.data

import com.test.myapplication.domain.Questions
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("/svc/books/v3/lists/names.json")
    suspend fun loadCategory(): Response<List<Questions>>
}