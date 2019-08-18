package com.example.tccapp.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.BindingAdapter
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.tccapp.R
import com.example.tccapp.Teacher
import com.example.tccapp.databinding.RowTeachersBinding
import com.example.tccapp.utils.SingleLiveEvent

class TeachersItemAdapter(
    val itemAdapterOnClickEvent: SingleLiveEvent<Int>
) : BaseBindingAdapter<Teacher, RowTeachersBinding>(R.layout.row_teachers) {

    override fun bind(holder: DataBindViewHolder<RowTeachersBinding>, position: Int) {
        holder.binding.viewModel =
            TeachersItemViewModel(
                items[position],
                itemAdapterOnClickEvent
            )
    }

    override fun getBinder(viewGroup: ViewGroup): RowTeachersBinding {
        return DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            layoutId,
            viewGroup,
            false
        )
    }

    companion object {
        @JvmStatic
        @BindingAdapter("teachersItems")
        fun setTeacherOptionItems(
            recyclerView: RecyclerView,
            teachers: List<Teacher>
        ) {
            val adapter = recyclerView.adapter
            if (adapter is TeachersItemAdapter) {
                adapter.update(teachers)
            }
        }
    }


}