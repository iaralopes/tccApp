package com.example.tccapp

import androidx.multidex.MultiDexApplication
import com.example.tccapp.di.CoreComponent
import com.example.tccapp.di.CoreComponentProvider
import com.example.tccapp.di.DaggerCoreComponent
import javax.inject.Inject

open class BaseApplication : MultiDexApplication(), CoreComponentProvider {

    @Inject
    lateinit var coreComponent: CoreComponent

    override fun onCreate() {
        super.onCreate()

        initComponent()
    }

    private fun initComponent() {
        coreComponent = DaggerCoreComponent
            .builder()
            .application(this)
            .build()
    }

    override fun providesCoreComponent(): CoreComponent = coreComponent
}