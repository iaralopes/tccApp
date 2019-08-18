package com.example.tccapp.di

import com.example.tccapp.TeacherDetailActivity
import com.example.tccapp.TeacherDetailViewModel
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.Provides

@Component(
    modules = [
        TeacherDetailModule::class
    ]
)

@FeatureScope
interface TeacherDetailComponent {

    fun inject(teacherDetailActivity: TeacherDetailActivity)

    @Component.Builder
    interface Builder {

        fun build(): TeacherDetailComponent

        @BindsInstance
        fun teacherDetailActivity(teacherDetailActivity: TeacherDetailActivity): Builder
    }
}

@Module
class TeacherDetailModule {

    @Provides
    fun providesTeachersViewModel(): TeacherDetailViewModel {
        return TeacherDetailViewModel()
    }
}