package com.example.moviesdb01.upcoming.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.moviesdb01.R
import com.example.moviesdb01.databinding.UpcomingfragmentBinding
import com.example.moviesdb01.upcoming.domain.model.UpcomingResult
import com.example.moviesdb01.upcoming.presentation.viewModel.UpcomingViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


class UpcomingFragment : Fragment(R.layout.upcomingfragment) {

    private var _binding: UpcomingfragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: UpcomingViewModel by viewModel()
    private val adapter by lazy {
        UpcomingAdapter()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        resultsObserver()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = UpcomingfragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        configRv()
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

    private fun configRv() {
        binding.recyclerViewXml02.adapter = adapter
        binding.recyclerViewXml02.layoutManager =
                //LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            GridLayoutManager(context, 2)
    }

    private fun resultsObserver() {
        viewModel.upcoming.observe(this, Observer {
            adapter.updateList(it.results as MutableList<UpcomingResult>)
        })
    }
}