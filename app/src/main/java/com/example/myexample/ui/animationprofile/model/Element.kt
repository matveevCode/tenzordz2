package com.example.myexample.ui.animationprofile.model

import com.example.myexample.R

data class Element(
    val id: Int,
    val avatar: Int,
    val fullName: String,
    val likeIcon: Int = R.drawable.ic_like
)
