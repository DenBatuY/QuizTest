package com.test.myapplication.data

import com.test.myapplication.domain.Questions
import retrofit2.Response
import retrofit2.http.GET

interface Service {

    @GET("v1/586ee45a-9173-40b5-afb0-47372d7ebdae")
    suspend fun loadCategory(): Response<List<Questions>>
}