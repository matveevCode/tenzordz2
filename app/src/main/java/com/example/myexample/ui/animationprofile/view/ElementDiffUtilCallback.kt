package com.example.myexample.ui.animationprofile.view

import androidx.recyclerview.widget.DiffUtil
import com.example.myexample.ui.animationprofile.model.Element

class ElementDiffUtilCallback(
    private val oldList: List<Element>,
    private val newList: List<Element>
) : DiffUtil.Callback() {

    override fun getOldListSize(): Int = oldList.size

    override fun getNewListSize(): Int = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean =
        oldList[oldItemPosition].id == newList[newItemPosition].id

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        val oldElement = oldList[oldItemPosition]
        val newElement = newList[newItemPosition]

        return oldElement.fullName == newElement.fullName &&
            oldElement.avatar == newElement.avatar &&
            oldElement.likeIcon == newElement.likeIcon
    }
}
