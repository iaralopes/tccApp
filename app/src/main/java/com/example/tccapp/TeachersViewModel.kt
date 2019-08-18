package com.example.tccapp

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TeachersViewModel @Inject constructor() : ViewModel() {
    val teachers = ObservableField<List<TeacherViewEntity>>(emptyList())

    init {
        teachers.set(
            listOf(
                TeacherViewEntity(1, "Lesandro"),
                TeacherViewEntity(2, "Guta"),
                TeacherViewEntity(3, "Rommel"),
                TeacherViewEntity(4, "Marcelo"),
                TeacherViewEntity(5, "Eveline")
            )
        )
    }

}