package com.example.androidassignment.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.navArgs
import coil.load
import com.example.androidassignment.R
import com.example.androidassignment.databinding.FragmentDetailBinding

class DetailFragment : Fragment() {

    private val binding by lazy {
        FragmentDetailBinding.inflate(layoutInflater)
    }

    private val args:DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        initView()
        return binding.root

    }

    private fun initView() {
        binding.apply {
            ivListImg.load(args.data.download_url)
            {
                placeholder(R.drawable.placeholder)
                error(R.drawable.placeholder)
            }
            tvTextDescription.text= "Author:  " + args.data.author
        }
    }
}