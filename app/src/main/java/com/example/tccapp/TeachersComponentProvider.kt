package com.example.tccapp

import android.app.Activity

interface TeachersComponentProvider {

    fun providesTeachersComponent(): TeachersComponent
}

fun Activity.teachersComponent() =
    (applicationContext as? TeachersComponentProvider)?.providesTeachersComponent()
        ?: throw IllegalStateException("TeachersComponentProvider not implemented: $applicationContext")
