package com.dojo.moovies.view.home

import android.R.attr.action
import android.R.attr.button
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.dojo.moovies.R
import com.dojo.moovies.databinding.FragmentHomeBinding


class HomeFragment : Fragment(
    R.layout.fragment_home
) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val homeBinding = FragmentHomeBinding.bind(view)

        initComponents(homeBinding)
    }

    private fun initComponents(homeBinding: FragmentHomeBinding) {

        homeBinding.btnHomeMyList.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchFragment)
        }

    }
}