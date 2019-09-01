package com.example.tccapp

import android.os.AsyncTask
import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.tccapp.service.SoapWebService
import com.example.tccapp.service.Teacher
import com.example.tccapp.service.TeacherDetail
import javax.inject.Inject

class TeacherDetailViewModel @Inject constructor() : ViewModel() {
    val name = ObservableField<String>()
    val teacherClass = ObservableField<String>()
    val description = ObservableField<String>()

    fun getDetails(id: Int) {
//        name.set("Nome do professor")
//        teacherClass.set("Aula do professor")
//        description.set("Descricao descricao descricao descricao descricao descricao descricao")

        GetTeacher().execute(id)
    }

    inner class GetTeacher : AsyncTask<Int, Any, TeacherDetail>() {
        override fun doInBackground(vararg params: Int?): TeacherDetail {
            val response = SoapWebService().getTeacher(SoapWebService.METHOD_GET_TEACHER, params[0])
            Log.v("response", "response==" + response)
            return response
        }

        override fun onPostExecute(result: TeacherDetail?) {
            super.onPostExecute(result)
            Log.v("response", "OnPostresponse==" + result)
            try {
                name.set(result?.name)
                teacherClass.set(result?.disciplines)
                description.set(result?.description)
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }

    }

}