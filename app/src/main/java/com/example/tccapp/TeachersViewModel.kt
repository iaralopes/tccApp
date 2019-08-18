package com.example.tccapp

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TeachersViewModel @Inject constructor() : ViewModel() {
    val teachers = ObservableField<List<Teacher>>(emptyList())

    init {
        teachers.set(
            listOf(
                Teacher(1, "Lesandro"),
                Teacher(2, "Guta"),
                Teacher(3, "Rommel"),
                Teacher(4, "Marcelo"),
                Teacher(5, "Eveline")
            )
        )
    }

}