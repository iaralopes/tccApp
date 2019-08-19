package com.example.tccapp.service

import com.apollographql.apollo.ApolloClient

object MyApolloClient{

    private val BASE_URL_GRAPHQL = "https://sheltered-depths-85535.herokuapp.com/graphql"
    val apolloClient: ApolloClient

    init {
        apolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL_GRAPHQL)
            .build()
    }
}