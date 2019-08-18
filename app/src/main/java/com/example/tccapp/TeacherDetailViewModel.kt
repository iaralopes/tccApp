package com.example.tccapp

import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import javax.inject.Inject

class TeacherDetailViewModel @Inject constructor(): ViewModel() {
    val name = ObservableField<String>()
    val teacherClass = ObservableField<String>()
    val description = ObservableField<String>()

    init {
        name.set("Nome do professor")
        teacherClass.set("Aula do professor")
        description.set("Descricao descricao descricao descricao descricao descricao descricao")
    }

}