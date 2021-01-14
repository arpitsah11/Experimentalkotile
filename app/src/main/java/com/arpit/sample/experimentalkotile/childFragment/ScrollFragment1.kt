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
import com.arpit.sample.experimentalkotile.FirstActivityModelView
import com.arpit.sample.experimentalkotile.R
import com.arpit.sample.experimentalkotile.databinding.FragmentHomeBinding
import com.arpit.sample.experimentalkotile.databinding.ScrollFragment1Binding
import com.arpit.sample.experimentalkotile.samples.SingletonWithHolder.Companion.TAG
import com.arpit.sample.experimentalkotile.ui.MYCustomView
import com.arpit.sample.experimentalkotile.ui.dashboard.DashboardFragment
import com.arpit.sample.experimentalkotile.ui.notifications.NotificationsFragment
import dagger.hilt.android.AndroidEntryPoint


class ScrollFragment1(private val bundle :Bundle) : Fragment() {

    private lateinit var binding: ScrollFragment1Binding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(DashboardFragment.TAG, "onCreateView Homefragment")
        binding = ScrollFragment1Binding.inflate(inflater)
        binding.fragmentName.setText("1");
        return binding.root
    }

}