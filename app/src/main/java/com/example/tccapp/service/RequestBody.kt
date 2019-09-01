package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "soap:Body", strict = false)
data class RequestBody (
    @field:Element(name = "GetTeachers" , required = false)
    var requestModel: RequestModel? = null
)