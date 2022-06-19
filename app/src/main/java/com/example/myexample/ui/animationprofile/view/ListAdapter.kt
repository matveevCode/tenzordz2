package com.example.myexample.ui.animationprofile.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.myexample.databinding.ItemElementBinding
import com.example.myexample.ui.animationprofile.model.Element


class ListAdapter(private val likeListener: (Int) -> Unit) :
    RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    private val elements: MutableList<Element> = mutableListOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemElementBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(elements[position], position)
    }

    override fun getItemCount(): Int = elements.size

    fun submitList(list: List<Element>) {
        elements.run {
            val diffResult = ElementDiffUtilCallback(elements, list).let { callback ->
                DiffUtil.calculateDiff(callback)
            }

            clear()
            addAll(list)

            diffResult.dispatchUpdatesTo(this@ListAdapter)
        }
    }

    inner class ViewHolder(private val binding: ItemElementBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(element: Element, position: Int) = binding.run {
            avatar.setImageResource(element.avatar)
            fullName.text = element.fullName

            likeButton.run {
                setImageResource(element.likeIcon)
                setOnClickListener { likeListener(position) }
            }
        }
    }
}
