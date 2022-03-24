package com.example.androidassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.WindowInsetsControllerCompat
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.androidassignment.R
import com.example.androidassignment.adapters.ImageAdapter
import com.example.androidassignment.databinding.FragmentHomeBinding
import com.example.androidassignment.viewmodel.HomeViewModel

class HomeFragment : Fragment() {

    private val binding by lazy {
        FragmentHomeBinding.inflate(layoutInflater)
    }

    private val homeViewModel by lazy {
        ViewModelProvider(this)[HomeViewModel::class.java]
    }

    private val imageAdapter by lazy {
        ImageAdapter{
            val action = HomeFragmentDirections.actionHomeFragmentToDetailFragment(it)
            findNavController().navigate(action)
        }
    }
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        initView()
        observer()
        getImage()
        return binding.root
    }
    private fun observer() {
        homeViewModel.listImage.observe(viewLifecycleOwner)
        {
            imageAdapter.submitList(it)
        }
    }

    private fun initView() {
        binding.apply {
            val layoutManager: RecyclerView.LayoutManager = StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL)
            rvImageList.layoutManager = layoutManager
            rvImageList.adapter=imageAdapter
        }
    }

    private fun getImage() {
        homeViewModel.getImageList()
    }

}