package com.example.tccapp.service

import org.simpleframework.xml.Serializer
import retrofit2.Retrofit
import retrofit2.converter.simplexml.SimpleXmlConverterFactory
import org.simpleframework.xml.core.Persister
import org.simpleframework.xml.convert.AnnotationStrategy
import org.simpleframework.xml.strategy.Strategy

class RetrofitInitializer {

    var strategy: Strategy = AnnotationStrategy()

    var serializer: Serializer = Persister(strategy)

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(SimpleXmlConverterFactory.create(serializer))
        .baseUrl("http://soap-tcc.herokuapp.com/")
        .build()

    fun teachersService() = retrofit.create(TeachersService::class.java)
}