package com.arpit.sample.experimentalkotile

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import com.arpit.sample.experimentalkotile.di.Repo1
import com.arpit.sample.experimentalkotile.di.Repo2

class FirstActivityModelView @ViewModelInject constructor(@Assisted private val stateHandle : SavedStateHandle, @Repo2 repo : IRepo ) : ViewModel() {

    val liveDate = stateHandle.getLiveData<String>("SKEY")

    companion object{
        private const val TAG = "FirstActivityModelView"
    }

    fun setValue(){
        stateHandle.set("SKEY", "FirstActivityModelView")
    }

    init {
        Log.i("Provider",  "${this.javaClass.name}  ${repo.getIdentity()}")
    }
}