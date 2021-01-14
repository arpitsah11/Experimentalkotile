package com.arpit.sample.experimentalkotile.ui.dashboard

import androidx.databinding.ObservableField
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class DashboardViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is dashboard Fragment"
    }
    val text: LiveData<String> = _text
    var paras : Int = 5

    var arpit : ObservableField<Int> = ObservableField()

    init {
        arpit.set(10)
    }

    fun setValue(str : String){

    }


}