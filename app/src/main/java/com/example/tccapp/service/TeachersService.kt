package com.example.tccapp.service

import retrofit2.Call
import retrofit2.http.GET

interface TeachersService {

    @GET("teachers")
    fun teachers(): Call<List<Teacher>>
}