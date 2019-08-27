package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "GetTeachersResult")
data class ResponseResult(
    @Element(name = "Teacher")
    val teacher: Teacher
)