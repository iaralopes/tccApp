package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "s:Body", strict = false)
data class ResponseBody (
    @Element(name = "GetTeachersResponse", required = false)
    val responseModel: ResponseModel? = null
)