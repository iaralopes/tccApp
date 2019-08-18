package com.example.tccapp

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.tccapp.service.RetrofitInitializer
import com.example.tccapp.service.TeacherDetail
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class TeacherDetailViewModel @Inject constructor(): ViewModel() {
    val name = ObservableField<String>()
    val teacherClass = ObservableField<String>()
    val description = ObservableField<String>()

    fun getDetails(id: Int) {
        val call = RetrofitInitializer().teachersService().teacherDetail(id)
        call.enqueue(object : retrofit2.Callback<TeacherDetail?> {
            override fun onResponse(
                call: Call<TeacherDetail?>?,
                response: Response<TeacherDetail?>?
            ) {
                response?.body()?.let {
                    name.set(it.name)
                    teacherClass.set(it.teacherClass)
                    description.set(it.description)
                }

            }

            override fun onFailure(
                call: Call<TeacherDetail?>?,
                t: Throwable?
            ) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

}