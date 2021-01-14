package com.arpit.sample.experimentalkotile.childFragment

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentFactory
import androidx.viewpager2.adapter.FragmentStateAdapter

class FragmentAdapter(val fragment :Fragment) {

    var pagerlistItem : ArrayList<Int> = ArrayList()

    fun setList(list: ArrayList<Int>){
        pagerlistItem = list
    }

   /* fun updateList(list: ArrayList<Int>){
        pagerlistItem = list
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return pagerlistItem.size
    }

    override fun createFragment(position: Int): Fragment {
        *//*val type  = pagerlistItem[position]
        when(type){
            1 -> fragment.childFragmentManager.beginTransaction().replace()
        }*//*

    }*/


}