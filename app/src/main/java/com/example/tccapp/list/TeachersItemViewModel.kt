package com.example.tccapp.list

import com.example.tccapp.Teacher
import com.example.tccapp.utils.SingleLiveEvent

class TeachersItemViewModel(
    val item: Teacher,
    val itemAdapterOnClickEvent: SingleLiveEvent<Int>
) {
    fun onClick() {
        itemAdapterOnClickEvent.postValue(item.id)
    }
}