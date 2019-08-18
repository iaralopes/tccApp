package com.example.tccapp

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import com.example.tccapp.service.RetrofitInitializer
import com.example.tccapp.service.Teacher
import retrofit2.Call
import retrofit2.Response
import javax.inject.Inject

class TeachersViewModel @Inject constructor() : ViewModel() {
    val teachers = ObservableField<List<Teacher>>(emptyList())

    init {
//        teachers.set(
//            listOf(
//                "Lesandro",
//                "Guta",
//                "Rommel",
//                "Marcelo",
//                "Eveline"
//            )
//        )

        val call = RetrofitInitializer().teachersService().teachers()
        call.enqueue(object: retrofit2.Callback<List<Teacher>?> {
            override fun onResponse(call: Call<List<Teacher>?>?,
                                    response: Response<List<Teacher>?>?) {
                response?.body()?.let {
                    teachers.set(it.map(Teacher::name))
                }
            }

            override fun onFailure(call: Call<List<Teacher>?>?,
                                   t: Throwable?) {
                Log.e("onFailure error", t?.message)
            }
        })
    }

}