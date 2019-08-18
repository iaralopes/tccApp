package com.example.tccapp.list

import com.example.tccapp.utils.SingleLiveEvent

class TeachersItemViewModel(
    val item: String,
    val itemAdapterOnClickEvent: SingleLiveEvent<String>
) {
    fun onClick() {
        itemAdapterOnClickEvent.postValue(item)
    }
}