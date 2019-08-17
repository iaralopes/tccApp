package com.example.tccapp

import android.os.Bundle
import com.example.tccapp.base.BaseActivity
import com.example.tccapp.base.ViewModelFactory
import javax.inject.Inject
import kotlin.properties.Delegates
import androidx.lifecycle.ViewModelProviders
import androidx.databinding.DataBindingUtil
import com.example.tccapp.databinding.ActivityTeachersBinding
import com.example.tccapp.list.TeachersItemAdapter

class TeachersActivity : BaseActivity() {

    private lateinit var binding: ActivityTeachersBinding

    @Inject
    lateinit var viewModeFactory: ViewModelFactory<TeachersViewModel>

    private val viewModel: TeachersViewModel by lazy {
        ViewModelProviders.of(this, viewModeFactory).get(TeachersViewModel::class.java)
    }

    private var component: TeachersComponent by Delegates.notNull()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        component = DaggerTeachersComponent
            .builder()
            .teachersActivity(this)
            .build()

        component.inject(this)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_teachers)
        binding.viewModel = viewModel
        binding.recyclerTeachers.adapter = TeachersItemAdapter()
    }
}
