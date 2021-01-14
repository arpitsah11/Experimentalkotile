package com.arpit.sample.experimentalkotile.samples

import android.content.Context
import android.util.Log

class NormalSingleton private constructor(context: Context){

    companion object{
        private const val TAG = "NormalSingleton"
        @Volatile
        private var INSTANCE : NormalSingleton? = null
        fun getInstance(context : Context) : NormalSingleton {
            val _instance = INSTANCE
            if(_instance != null){
                return _instance
            }
            synchronized(this){
                var ins = INSTANCE
                if(ins != null){
                    return ins
                }
                ins = NormalSingleton(context)
                INSTANCE = ins
                return ins
            }
        }
    }

    fun print(){
        Log.i(TAG, "hello")
    }

}