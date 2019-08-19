package com.example.tccapp

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.apollographql.apollo.ApolloCall
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.exception.ApolloException
import com.example.tccapp.service.MyApolloClient
import javax.inject.Inject

class TeacherDetailViewModel @Inject constructor(): ViewModel() {
    val name = ObservableField<String>()
    val teacherClass = ObservableField<String>()
    val description = ObservableField<String>()

    fun getDetails(id: String) {
        MyApolloClient.apolloClient.query(
            TeacherDetailQuery
                .builder()
                .id(id)
                .build()
        ).enqueue(object : ApolloCall.Callback<TeacherDetailQuery.Data>() {
            override fun onResponse(response: Response<TeacherDetailQuery.Data>) {
                val teacher = response?.data()?.teacher
                name.set(teacher?.name)
                teacherClass.set(teacher?.disciplines)
                description.set(teacher?.description)
            }

            override fun onFailure(e: ApolloException) {
                Log.e("onFailure error", e.message)
            }
        })
    }
}
