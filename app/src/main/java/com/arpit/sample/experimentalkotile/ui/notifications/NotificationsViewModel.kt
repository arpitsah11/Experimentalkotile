package com.arpit.sample.experimentalkotile.ui.notifications

import android.app.Application
import android.util.Log
import androidx.databinding.BaseObservable
import androidx.databinding.Bindable
import androidx.databinding.ObservableField
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.arpit.sample.experimentalkotile.FakeRepo
import com.arpit.sample.experimentalkotile.IRepo
import com.arpit.sample.experimentalkotile.di.Repo1

class NotificationsViewModel @ViewModelInject constructor(@Repo1 private  val repo : IRepo) : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is notifications Fragment"
    }
    val text: LiveData<String> = _text

    val liveDataFlow = repo.getDataForFlow()
    val liveDataChannel = repo.getDataForChannel()

    var myText : ObservableField<String> = ObservableField<String>()
    set(value) {
        field = value
        Log.i("","")
    }
    get() {
        return field
    }

    var sam : String =""
    set(value){
        field = value
    }get() = field

    init {
        Log.i("Provider",  "${this.javaClass.name}  ${repo.getIdentity()}")
    }

    fun userRequest(){
        //repo.flowWork()
        repo.channelWork()
    }

}