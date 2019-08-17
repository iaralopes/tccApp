package com.example.tccapp

import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [
        TeachersModule::class
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
    }
}

@Module
class TeachersModule {

    @Provides
    fun providesTeachersViewModel(): TeachersViewModel {
        return TeachersViewModel()
    }
}