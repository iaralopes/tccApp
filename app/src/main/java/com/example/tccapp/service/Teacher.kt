package com.example.tccapp.service

import com.tickaroo.tikxml.annotation.Attribute
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "teacher")
data class Teacher(
    @Attribute(name = "id")
    val id: String,
    @Attribute(name = "name")
    val name: String
)