package com.example.tccapp.service

import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST

interface TeachersService {

    @Headers(
        "Content-Type: text/xml; charset=utf-8",
        "SOAPAction: http://tempuri.org/GetTeachers"
    )
    @POST("Service.asmx")
    fun teachers(@Body requestEnvelope: RequestEnvelope): Call<ResponseEnvelope>
}