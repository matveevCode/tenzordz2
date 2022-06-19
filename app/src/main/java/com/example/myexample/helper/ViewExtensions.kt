package com.example.myexample.helper

import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myexample.R

fun RecyclerView.setupGridDecorator() {
    DividerItemDecoration(context, GridLayoutManager.HORIZONTAL).run {
        setDrawable(ContextCompat.getDrawable(context, R.drawable.ic_divider)!!)
        addItemDecoration(this)
    }
    DividerItemDecoration(context, GridLayoutManager.VERTICAL).run {
        setDrawable(ContextCompat.getDrawable(context, R.drawable.ic_divider)!!)
        addItemDecoration(this)
    }
}
