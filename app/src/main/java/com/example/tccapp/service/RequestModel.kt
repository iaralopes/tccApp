package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(name = "GetTeachers", strict = false)
@Namespace(reference = "http://tempuri.org/")
data class RequestModel (
    @field:Element(name = "Code", required = false)
    var code: String? = ""
)