package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Namespace
import org.simpleframework.xml.NamespaceList
import org.simpleframework.xml.Root


@Root(name = "soap:Envelope")
@NamespaceList(
    Namespace(reference = "http://schemas.xmlsoap.org/soap/envelope/", prefix = "soap"),
    Namespace(reference = "http://www.w3.org/2001/XMLSchema-instance", prefix = "xsi"),
    Namespace(reference = "http://www.w3.org/2001/XMLSchema", prefix = "xsd")
)

data class RequestEnvelope(
    @Element(name = "soap:Body", required = false)
    var body: RequestBody? = null
)