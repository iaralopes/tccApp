package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Teacher")
data class Teacher(
    @Element(name = "Id", required = false)
    val id: String,
    @Element(name = "Name", required = false)
    val name: String
)