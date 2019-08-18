package com.example.tccapp.list

import com.example.tccapp.TeacherViewEntity
import com.example.tccapp.utils.SingleLiveEvent

class TeachersItemViewModel(
    val item: TeacherViewEntity,
    val itemAdapterOnClickEvent: SingleLiveEvent<Int>
) {
    fun onClick() {
        itemAdapterOnClickEvent.postValue(item.id)
    }
}