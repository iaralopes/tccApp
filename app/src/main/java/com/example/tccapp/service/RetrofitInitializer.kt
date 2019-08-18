package com.example.tccapp.service

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
            .baseUrl("https://api.tcc.com.br/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()


    fun teachersService() = retrofit.create(TeacherService::class.java)
}