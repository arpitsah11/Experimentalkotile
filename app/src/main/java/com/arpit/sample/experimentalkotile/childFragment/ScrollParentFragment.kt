package com.arpit.sample.experimentalkotile.childFragment

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import androidx.viewpager2.widget.ViewPager2
import com.arpit.sample.experimentalkotile.FirstActivityModelView
import com.arpit.sample.experimentalkotile.R
import com.arpit.sample.experimentalkotile.databinding.FragmentHomeBinding
import com.arpit.sample.experimentalkotile.databinding.FragmentViewPagerBinding
import com.arpit.sample.experimentalkotile.samples.SingletonWithHolder.Companion.TAG
import com.arpit.sample.experimentalkotile.ui.MYCustomView
import com.arpit.sample.experimentalkotile.ui.dashboard.DashboardFragment
import com.arpit.sample.experimentalkotile.ui.notifications.NotificationsFragment
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint


class ScrollParentFragment(private val bundle :Bundle) : Fragment() {

    private lateinit var binding: FragmentViewPagerBinding
    private lateinit var pager : ViewPager2
    private lateinit var adapter1 :FragmentAdapter

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(DashboardFragment.TAG, "onCreateView Homefragment")
        binding = FragmentViewPagerBinding.inflate(inflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        /*pager = binding.pager
        adapter1 = FragmentAdapter(this)
        pager.adapter =adapter1
        TabLayoutMediator(binding.tabLayout, pager){tab, position->
            tab.text = ""
        }.attach()*/

    }

}