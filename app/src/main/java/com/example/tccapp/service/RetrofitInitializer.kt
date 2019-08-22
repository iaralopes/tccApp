package com.example.tccapp.service

import com.tickaroo.tikxml.retrofit.TikXmlConverterFactory
import retrofit2.Retrofit

class RetrofitInitializer {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://api.tcc.com.br/")
        .addConverterFactory(TikXmlConverterFactory.create())
        .build()

    fun teachersService() = retrofit.create(TeachersService::class.java)
}