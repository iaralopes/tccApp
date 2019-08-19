package com.example.tccapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.example.tccapp.databinding.ActivityTeacherDetailBinding
import com.example.tccapp.di.DaggerTeacherDetailComponent
import com.example.tccapp.di.TeacherDetailComponent
import com.example.tccapp.di.ViewModelFactory
import javax.inject.Inject
import kotlin.properties.Delegates

class TeacherDetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityTeacherDetailBinding

    @Inject
    lateinit var viewModeFactory: ViewModelFactory<TeacherDetailViewModel>

    private val viewModel: TeacherDetailViewModel by lazy {
        ViewModelProviders.of(this, viewModeFactory).get(TeacherDetailViewModel::class.java)
    }

    private var component: TeacherDetailComponent by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component = DaggerTeacherDetailComponent
            .builder()
            .teacherDetailActivity(this)
            .build()

        component.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_detail)
        binding.viewModel = viewModel

        viewModel.getDetails(intent.getStringExtra("id"))
    }
}