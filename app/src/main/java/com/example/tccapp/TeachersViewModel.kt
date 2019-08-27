package com.example.tccapp

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.tccapp.service.RequestEnvelope
import com.example.tccapp.service.ResponseEnvelope
import com.example.tccapp.service.RetrofitInitializer
import com.example.tccapp.service.Teacher
import retrofit2.Call
import retrofit2.Response
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

        val call = RetrofitInitializer().teachersService().teachers(RequestEnvelope())
        call.enqueue(object : retrofit2.Callback<ResponseEnvelope> {
            override fun onResponse(
                call: Call<ResponseEnvelope>?,
                response: Response<ResponseEnvelope>?
            ) {
                response?.body()?.let {
                    teachers.set(
                        it.body?.map {
                            TeacherViewEntity(
                                it.id,
                                it.name
                            )
                        }
                    )
                }
            }

            override fun onFailure(call: Call<ResponseEnvelope>?, t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        }
        )
    }

}