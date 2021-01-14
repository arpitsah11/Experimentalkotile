package com.arpit.sample.experimentalkotile.ui.notifications

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.Navigation
import com.arpit.sample.experimentalkotile.FakeRepo
import com.arpit.sample.experimentalkotile.R
import com.arpit.sample.experimentalkotile.databinding.FragmentNotificationsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@AndroidEntryPoint
class NotificationsFragment : Fragment() {

    private lateinit var notificationsViewModel: NotificationsViewModel
    private lateinit var binding : FragmentNotificationsBinding
    /*@Inject
    private lateinit var factory : FragmentModelViewFactory*/

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding =  FragmentNotificationsBinding.inflate(inflater)
        notificationsViewModel =
            ViewModelProvider(this, ).get(NotificationsViewModel::class.java)
        binding.viewModel = notificationsViewModel
        notificationsViewModel.text.observe(viewLifecycleOwner, Observer {
            binding.textHeader.text = it
        })
        binding.button.setText("Home")
        binding.button.setOnClickListener(){
            val args = Bundle()
            args.putString("caller", NotificationsFragment::class.java.name)
            Navigation.findNavController(it).navigate(R.id.action_navigation_notifications_to_navigation_home, args)
        }
        binding.button2.setText("DashBoard")
        binding.button2.setOnClickListener(){
            val args = Bundle()
            args.putString("caller", NotificationsFragment::class.java.name)
            Navigation.findNavController(it).navigate(R.id.action_navigation_notifications_to_navigation_dashboard,args)
        }
        val arg = arguments?.getString("KEY")
        binding.textView.setText(arg)
        println("args value ${arguments?.get("caller")}")
        return binding.root
    }

    override fun onResume() {
        register()
        Log.i(FakeRepo.TAG,"notification fragment on resume")
        notificationsViewModel.myText.set("helloooooooooooo")
        lifecycleScope.launch{
            withContext(Dispatchers.Default){
                Log.i(FakeRepo.TAG,"notification fragment trigger delay before request")
                delay(500)
                Log.i(FakeRepo.TAG,"notification fragment trigger post delay before request")
                notificationsViewModel.userRequest()
            }
        }
        super.onResume()
    }

    private fun register() {
        notificationsViewModel.liveDataFlow.observe(viewLifecycleOwner){
            Log.i(FakeRepo.TAG," flow data $it")
        }

        notificationsViewModel.liveDataChannel.observe(viewLifecycleOwner){
            Log.i(FakeRepo.TAG, "Channel data $it")
        }
    }
}