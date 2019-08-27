package com.example.tccapp.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST

interface TeachersService {

    @Headers("Content-Type: text/xml")
    @POST("Service.asmx")
    fun teachers(@Body requestEnvelope: RequestEnvelope): Call<ResponseEnvelope>
}