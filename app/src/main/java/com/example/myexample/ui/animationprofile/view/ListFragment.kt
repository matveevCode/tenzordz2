package com.example.myexample.ui.animationprofile.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.myexample.databinding.FragmentListBinding
import com.example.myexample.helper.setupGridDecorator
import com.example.myexample.ui.animationprofile.viewmodel.ListViewModel

class ListFragment : Fragment() {

    private lateinit var binding: FragmentListBinding

    private val viewModel: ListViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentListBinding.inflate(inflater, container, false).run {
        binding = this
        root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
        initObservers()
    }

    private fun initViews() {
        binding.recyclerView.run {
            adapter = ListAdapter(viewModel::onLikeButtonClick)
            setupGridDecorator()
        }
    }

    private fun initObservers() {
        viewModel.elements.observe(viewLifecycleOwner) { elements ->
            (binding.recyclerView.adapter as? ListAdapter)?.submitList(elements)
        }
    }
}
