package com.example.tccapp

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.tccapp.service.MyApolloClient
import javax.inject.Inject

class TeachersViewModel @Inject constructor() : ViewModel() {
    val teachers = ObservableField<List<TeacherViewEntity>>(emptyList())

    init {
//        teachers.set(
//            listOf(
//                TeacherViewEntity(1, "Lesandro"),
//                TeacherViewEntity(2, "Guta"),
//                TeacherViewEntity(3, "Rommel"),
//                TeacherViewEntity(4, "Marcelo"),
//                TeacherViewEntity(5, "Eveline")
//            )
//        )

        MyApolloClient.apolloClient.query(
            TeachersQuery.builder()
                .build()
        ).enqueue(object : ApolloCall.Callback<TeachersQuery.Data>() {
            override fun onResponse(response: Response<TeachersQuery.Data>) {
                teachers.set(response.data()?.teachers?.map {
                    TeacherViewEntity(it.id, it.name)
                }
                )
            }

            override fun onFailure(e: ApolloException) {
                Log.e("onFailure error", e.message)
            }
        })
    }

}