package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.Root

@Root(name = "GetTeachersResponse")
@Namespace(reference = "http://tempuri.org/")
data class ResponseModel(
    @Element(name = "GetTeachersResult")
    val responseResult: List<ResponseResult>
)