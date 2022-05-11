package com.example.moviesdb01.popular.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AbsListView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb01.R
import com.example.moviesdb01.databinding.MoviesfragmentBinding
import com.example.moviesdb01.popular.domain.model.MoviesResult
import com.example.moviesdb01.popular.presentation.viewModel.MoviesViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MoviesFragment : Fragment(R.layout.moviesfragment) {

    private var _binding: MoviesfragmentBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MoviesViewModel by viewModel()
    private val adapter by lazy {
        MoviesAdapter()
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
        _binding = MoviesfragmentBinding.inflate(inflater, container, false)
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
        binding.recyclerViewXml.adapter = adapter
        binding.recyclerViewXml.layoutManager =
                //LinearLayoutManager(context, GridLayoutManager.VERTICAL, false)
            GridLayoutManager(context, 2)
    }

    private fun resultsObserver() {
        viewModel.movies.observe(this, Observer {
            adapter.updateList(it.results as MutableList<MoviesResult>)
        })
    }
}