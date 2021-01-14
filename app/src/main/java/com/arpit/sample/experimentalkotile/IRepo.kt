package com.arpit.sample.experimentalkotile

import androidx.lifecycle.LiveData

interface IRepo {

    fun flowWork()

    fun channelWork()

    fun getDataForChannel(): LiveData<String>

    fun getDataForFlow(): LiveData<Int>

    fun getIdentity(): String
}