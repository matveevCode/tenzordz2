package com.example.myexample.ui.animationprofile.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.myexample.R
import com.example.myexample.data.ElementRepository
import com.example.myexample.ui.animationprofile.model.Element

class ListViewModel : ViewModel() {

    private val mutableElements = MutableLiveData(ElementRepository.elements)
    val elements: LiveData<List<Element>> = mutableElements

    fun onLikeButtonClick(position: Int) = mutableElements.value
        ?.toMutableList()
        ?.let { mutableList ->
            val element = mutableList[position]
            val likeIcon = if (element.likeIcon == R.drawable.ic_like) {
                R.drawable.ic_like_selected
            } else {
                R.drawable.ic_like
            }

            mutableList[position] = element.copy(likeIcon = likeIcon)
            mutableElements.postValue(mutableList)
        }
}
