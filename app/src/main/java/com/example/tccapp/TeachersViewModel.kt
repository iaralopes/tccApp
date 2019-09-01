package com.example.tccapp

import android.os.AsyncTask
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.tccapp.service.SoapWebService
import com.example.tccapp.service.SoapWebService.Companion.METHOD_GET_LIST
import com.example.tccapp.service.Teacher
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
        GetTeachers().execute()
    }

    inner class GetTeachers : AsyncTask<Any, Any, List<Teacher>>() {
        override fun doInBackground(vararg params: Any): List<Teacher> {
            val response = SoapWebService().getTeachers(METHOD_GET_LIST)
            Log.v("response", "response==" + response)
            return response
        }

        override fun onPostExecute(result: List<Teacher>?) {
            super.onPostExecute(result)
            Log.v("response", "OnPostresponse==" + result)
            try {
                teachers.set(result?.map {
                    TeacherViewEntity(
                        it.id ?: "",
                        it.name ?: ""
                    )
                })
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

}