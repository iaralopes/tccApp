package com.example.tccapp.di

import android.app.Activity

interface CoreComponentProvider {

    fun providesCoreComponent(): CoreComponent
}

fun Activity.coreComponent() =
    (applicationContext as? CoreComponentProvider)?.providesCoreComponent()
        ?: throw IllegalStateException("CoreComponentProvider not implemented: $applicationContext")
