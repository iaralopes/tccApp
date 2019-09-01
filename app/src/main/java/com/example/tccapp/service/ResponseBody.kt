package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Body", strict = false)
data class ResponseBody (
    @field:Element(name = "GetTeachersResponse", required = false)
    var responseModel: ResponseModel? = null
)