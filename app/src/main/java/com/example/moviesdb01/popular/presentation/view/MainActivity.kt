package com.example.moviesdb01.popular.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.recyclerview.widget.RecyclerView
import com.example.moviesdb01.R
import com.example.moviesdb01.databinding.ActivityMainBinding
import com.example.moviesdb01.upcoming.presentation.view.UpcomingFragment
import io.reactivex.internal.disposables.DisposableHelper
import io.reactivex.internal.disposables.DisposableHelper.replace

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var popMovies_button: Button
    private lateinit var upcoming_button: Button

    private lateinit var popMoviesFragment: MoviesFragment
    private lateinit var upComingFragment: UpcomingFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        popMoviesFragment = MoviesFragment()
        upComingFragment = UpcomingFragment()
        configFr()

    }


    private fun configFr() {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.frame_fragment, popMoviesFragment)
            addToBackStack(null)
            commit()
        }

        binding.popularButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_fragment, popMoviesFragment)
                addToBackStack(null)
                commit()
            }
        }
        binding.UpcomingButton.setOnClickListener {
            supportFragmentManager.beginTransaction().apply {
                replace(R.id.frame_fragment, upComingFragment)
                addToBackStack(null)
                commit()
            }
        }
    }

    //simplificação da confiFr em desenvolvimento

    /*private fun setFragment(fragment: Fragment) {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_fragment,fragment)
        fragmentTransaction.commit()
    }*/
}