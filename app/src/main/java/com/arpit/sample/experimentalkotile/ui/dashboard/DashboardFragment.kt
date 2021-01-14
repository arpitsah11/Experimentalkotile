package com.arpit.sample.experimentalkotile.ui.dashboard

import android.content.Context
import android.os.Bundle
import android.util.Log
import android.view.*
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.arpit.sample.experimentalkotile.R
import com.arpit.sample.experimentalkotile.databinding.FragmentDashboardBinding
import com.arpit.sample.experimentalkotile.ui.home.HomeFragment

class DashboardFragment(private val bundle : Bundle) : Fragment() {

    companion object{
        public const val TAG = "DashboardFragment"
    }

    private lateinit var dashboardViewModel: DashboardViewModel
    private lateinit var binding :FragmentDashboardBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        
        Log.i(TAG, "onCreateView DashboardFragment")
        dashboardViewModel =
            ViewModelProvider(this).get(DashboardViewModel::class.java)
        binding = FragmentDashboardBinding.inflate(inflater)
        binding.viewModel = dashboardViewModel
        binding.button.setText("Home")
        setHasOptionsMenu(true)
        binding.button.setOnClickListener(){
            val args = Bundle()
            args.putString("caller", DashboardFragment::class.java.name)
            Navigation.findNavController(it).navigate(R.id.action_navigation_dashboard_to_navigation_home,args)
        }
        binding.button2.setText("Notification")
        binding.button2.setOnClickListener(){
            val args = Bundle()
            args.putString("caller", DashboardFragment::class.java.name)
            Navigation.findNavController(it).navigate(R.id.action_navigation_dashboard_to_navigation_notifications,args)
        }
        val arg = arguments?.getString("KEY")
        binding.textView.setText(arg)
        println("args value ${arguments?.get("caller")}")
        println("data from constructor ${bundle.get("KEY")}")
        return binding.root
    }



    override fun onDestroyView() {
        Log.i(TAG, "ondestroy view DashboardFragment")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.i(TAG, "ondestroy DashboardFragment")
        super.onDestroy()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        Log.i(TAG, "onview created DashboardFragment")
        super.onViewCreated(view, savedInstanceState)
    }


    override fun onDetach() {
        Log.i(TAG, "onDetach DashboardFragment")
        super.onDetach()
    }

    override fun onAttach(context: Context) {
        Log.i(TAG, "onAttach DashboardFragment")
        super.onAttach(context)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        Log.i(TAG, "onCreate DashboardFragment")
        super.onCreate(savedInstanceState)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        Log.i(TAG, "onactivity created DashboardFragment")
        super.onActivityCreated(savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        Log.i("sam11", "onCreateOptionsMenu dashboard")
        menu.clear()
        inflater.inflate(R.menu.action_menu, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

}