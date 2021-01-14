package com.arpit.sample.experimentalkotile.samples

import android.content.Context
import android.util.Log

class SingletonWithHolder private constructor(context : Context) {

    //companion object : SingletonHolder<SingletonWithHolder, Context>(:: SingletonWithHolder)

    companion object{
        const val TAG = "SingletonWithHolder"
        object Singleton : SingletonHolder<SingletonWithHolder, Context>(:: SingletonWithHolder)
    }

    fun print (){
        Log.i(TAG, "hello   ........")
    }

}