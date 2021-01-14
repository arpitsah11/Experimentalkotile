package com.arpit.sample.experimentalkotile.ui.home

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
import com.arpit.sample.experimentalkotile.samples.SingletonWithHolder.Companion.TAG
import com.arpit.sample.experimentalkotile.ui.MYCustomView
import com.arpit.sample.experimentalkotile.ui.dashboard.DashboardFragment
import com.arpit.sample.experimentalkotile.ui.notifications.NotificationsFragment
import dagger.hilt.android.AndroidEntryPoint


class HomeFragment(private val bundle :Bundle) : Fragment() {

    private lateinit var homeViewModel: HomeViewModel
    private lateinit var activityModelView: FirstActivityModelView
    private lateinit var binding: FragmentHomeBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        Log.i(DashboardFragment.TAG, "onCreateView Homefragment")
        activityModelView = ViewModelProvider(requireActivity()).get(FirstActivityModelView::class.java)
        homeViewModel =
            ViewModelProvider(this).get(HomeViewModel::class.java)
        binding = FragmentHomeBinding.inflate(inflater)
        binding.viewModel = homeViewModel
        homeViewModel.myText ="This is home Fragment";
        binding.button.setText("DashBoard")
        binding.button.setOnClickListener(){
            activityModelView.setValue()
            val args = Bundle()
            args.putString("caller", HomeFragment::class.java.name)
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_dashboard,args)
        }
        binding.button2.setText("Notification")
        binding.button2.setOnClickListener(){
            val args = Bundle()
            args.putString("caller", HomeFragment::class.java.name)
            Navigation.findNavController(it).navigate(R.id.action_navigation_home_to_navigation_notifications,args)
        }
        val arg = arguments?.getString("KEY")
        binding.textView.setText(arg)
        println("args value ${arguments?.get("caller")}")
        println("data from constructor ${bundle.get("KEY")}")
        activityModelView.liveDate.observe(viewLifecycleOwner, Observer {
            println(it)
        })

        binding.customButton.setOnClickListener() {
            Log.i("myarpit","onclick")
            when (binding.customButton.getState()) {
                MYCustomView.STATE_ACTIVE -> binding.customButton.setCustomState(MYCustomView.STATE_UNKNOWN)
                MYCustomView.STATE_INACTIVE -> binding.customButton.setCustomState(MYCustomView.STATE_ACTIVE)
                MYCustomView.STATE_AVAILABLE -> binding.customButton.setCustomState(MYCustomView.STATE_INACTIVE)
                MYCustomView.STATE_UNAVAILABLE -> binding.customButton.setCustomState(MYCustomView.STATE_AVAILABLE)
                else -> binding.customButton.setCustomState(MYCustomView.STATE_UNAVAILABLE)
            }
        }

        return binding.root
    }



    override fun onDestroyView() {
        Log.i(DashboardFragment.TAG, "ondestroy view Homefragment")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i(DashboardFragment.TAG, "ondestroy Homefragment")
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(DashboardFragment.TAG, "onview created Homefragment")
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDetach() {
        Log.i(DashboardFragment.TAG, "onDetach Homefragment")
        super.onDetach()
    }

    override fun onAttach(context: Context) {
        Log.i(DashboardFragment.TAG, "onAttach Homefragment")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(DashboardFragment.TAG, "onCreate Homefragment")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(DashboardFragment.TAG, "onactivity created Homefragment")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onStop() {
        Log.i(DashboardFragment.TAG, "onstop Homefragment")
        super.onStop()
    }

    override fun onStart() {
        Log.i(DashboardFragment.TAG, "onstart Homefragment")
        super.onStart()
    }

    override fun onResume() {
        Log.i(DashboardFragment.TAG, "onResume Homefragment")
        super.onResume()
    }
}