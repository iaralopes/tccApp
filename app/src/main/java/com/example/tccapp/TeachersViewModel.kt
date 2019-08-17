package com.example.tccapp

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TeachersViewModel @Inject constructor() : ViewModel() {
    val teachers = ObservableField<List<String>>(emptyList())

    init {
        teachers.set(
            listOf(
                "Lesandro",
                "Guta",
                "Rommel",
                "Marcelo",
                "Eveline"
            )
        )
    }

}