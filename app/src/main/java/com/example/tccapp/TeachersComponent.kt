package com.example.tccapp

import com.example.tccapp.di.CoreComponent
import dagger.BindsInstance
import dagger.Component
import dagger.Module

@Component(
    modules = [
        TeachersModule::class
    ],
    dependencies = [
        CoreComponent::class
    ]
)

@FeatureScope
interface TeachersComponent {

    fun inject(teachersActivity: TeachersActivity)

    @Component.Builder
    interface Builder {

        fun build(): TeachersComponent

        @BindsInstance
        fun teachersActivity(teachersActivity: TeachersActivity): Builder

        fun coreComponent(coreComponent: CoreComponent): Builder
    }
}

@Module
class TeachersModule {

}