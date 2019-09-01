package com.example.tccapp.service

import org.simpleframework.xml.Element
import org.simpleframework.xml.Root

@Root(name = "Teacher")
data class Teacher(
    @field:Element(name = "Id", required = false)
    var id: String? = "",
    @field:Element(name = "Name", required = false)
    var name: String? = "",
    @field:Element(name = "Disciplines", required = false)
    var disciplines: String? = "",
    @field:Element(name = "Description", required = false)
    var description: String? = "",
    @field:Element(name = "University", required = false)
    var university: String? = "",
    @field:Element(name = "Birthday", required = false)
    var birthday: String? = ""
)