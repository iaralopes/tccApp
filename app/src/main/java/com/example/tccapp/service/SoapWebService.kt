package com.example.tccapp.service

import org.ksoap2.SoapEnvelope
import org.ksoap2.serialization.SoapObject
import org.ksoap2.serialization.SoapSerializationEnvelope
import org.ksoap2.transport.HttpTransportSE

class SoapWebService {

    companion object {
        val SOAP_URL = "http://soap-tcc.herokuapp.com/Service.asmx?"
        val SOAP_NAMESPACE = "http://tempuri.org/"
        val METHOD_GET_LIST = "GetTeachers"
        val METHOD_GET_TEACHER = "GetTeacher"
    }

    fun getTeachers(methodName: String): List<Teacher> {
        val teachersResult = mutableListOf<Teacher>()
        val soapAction = SOAP_NAMESPACE + methodName
        val soapObject = SoapObject(SOAP_NAMESPACE, methodName)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = true

        val httpTransportSE = HttpTransportSE(SOAP_URL)

        try {
            httpTransportSE.call(soapAction, envelope)
            val envelopeResponse = envelope.response as SoapObject
            for (i in 1..envelopeResponse.propertyCount) {
                val obj = envelopeResponse.getProperty(i - 1) as SoapObject
                teachersResult.add(
                    Teacher(
                        id = obj.getPropertySafelyAsString("Id").toString(),
                        name = obj.getPropertySafelyAsString("Name").toString()
                    )
                )
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return teachersResult
    }


    fun getTeacher(methodName: String, input: Int?): TeacherDetail {
        val soapAction = SOAP_NAMESPACE + methodName
        val soapObject = SoapObject(SOAP_NAMESPACE, methodName)

        soapObject.addProperty("id", input)

        val envelope = SoapSerializationEnvelope(SoapEnvelope.VER11)
        envelope.setOutputSoapObject(soapObject)
        envelope.dotNet = true

        val httpTransportSE = HttpTransportSE(SOAP_URL)

        try {
            httpTransportSE.call(soapAction, envelope)
            val envelopeResponse = envelope.response as SoapObject
            return TeacherDetail(
                id = envelopeResponse.getPropertySafelyAsString("Id").toString(),
                name = envelopeResponse.getPropertySafelyAsString("Name").toString(),
                disciplines = envelopeResponse.getPropertySafelyAsString("Disciplines"),
                university = envelopeResponse.getPropertySafelyAsString("University").toString(),
                birthday = envelopeResponse.getPropertySafelyAsString("Birthday").toString(),
                description = envelopeResponse.getPropertySafelyAsString("Description").toString()
            )
        } catch (e: Exception) {
            e.printStackTrace()
        }

        return TeacherDetail()
    }
}