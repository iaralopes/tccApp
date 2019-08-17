package com.example.tccapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView

abstract class BaseBindingAdapter<T, V : ViewDataBinding>(
    protected val layoutId: Int
) : RecyclerView.Adapter<BaseBindingAdapter.DataBindViewHolder<V>>() {

    protected var items = mutableListOf<T>()

    override fun onCreateViewHolder(viewGroup: ViewGroup, type: Int): DataBindViewHolder<V> {
        val binder = getBinder(viewGroup)
        return DataBindViewHolder(binder)
    }

    open fun getBinder(viewGroup: ViewGroup): V {
        return DataBindingUtil.inflate(
            LayoutInflater.from(viewGroup.context),
            layoutId,
            viewGroup,
            false
        )
    }

    override fun onBindViewHolder(holder: DataBindViewHolder<V>, position: Int) {
        bind(holder, position)
        holder.binding.executePendingBindings()
    }

    override fun getItemCount() = items.size

    fun update(update: List<T>) {
        items.clear()
        items.addAll(update)
        notifyDataSetChanged()
    }

    protected abstract fun bind(holder: DataBindViewHolder<V>, position: Int)

    class DataBindViewHolder<out T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)
}