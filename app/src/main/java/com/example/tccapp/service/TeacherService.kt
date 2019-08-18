package com.example.tccapp.service

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface TeacherService {

    @GET("teachers")
    fun teachers(): Call<List<Teacher>>

    @GET("teachers/{id}")
    fun teacherDetail(@Path("id") id: Int): Call<TeacherDetail>
}