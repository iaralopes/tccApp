package com.example.tccapp.service

import com.apollographql.apollo.ApolloClient

object MyApolloClient{

    private val BASE_URL_GRAPHQL = "http://157.230.182.47/graphql"
    val apolloClient: ApolloClient

    init {
        apolloClient = ApolloClient.builder()
            .serverUrl(BASE_URL_GRAPHQL)
            .build()
    }
}