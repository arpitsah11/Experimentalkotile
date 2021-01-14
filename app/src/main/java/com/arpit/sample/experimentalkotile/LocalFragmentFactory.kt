package com.arpit.sample.experimentalkotile

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import com.arpit.sample.experimentalkotile.ui.dashboard.DashboardFragment
import com.arpit.sample.experimentalkotile.ui.home.HomeFragment

class LocalFragmentFactory(private val data: Bundle) : FragmentFactory() {

    override fun instantiate(classLoader: ClassLoader, className: String): Fragment {
        return when(className){
            DashboardFragment::class.java.name -> DashboardFragment(data)
            HomeFragment::class.java.name-> HomeFragment(data)
            else -> super.instantiate(classLoader, className)
        }
    }
}