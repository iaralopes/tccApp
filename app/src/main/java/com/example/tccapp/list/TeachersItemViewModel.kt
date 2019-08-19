package com.example.tccapp.list

import com.example.tccapp.TeacherViewEntity
import com.example.tccapp.utils.SingleLiveEvent

class TeachersItemViewModel(
    val item: TeacherViewEntity,
    val itemAdapterOnClickEvent: SingleLiveEvent<String>
) {
    fun onClick() {
        itemAdapterOnClickEvent.postValue(item.id)
    }
}