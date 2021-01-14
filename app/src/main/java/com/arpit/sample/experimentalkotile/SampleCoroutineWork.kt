package com.arpit.sample.experimentalkotile

import android.content.Context
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.work.CoroutineWorker
import androidx.work.Data
import androidx.work.WorkerParameters

class SampleCoroutineWork(context: Context,val parms: WorkerParameters) : CoroutineWorker(context, parms) {

    override suspend fun doWork(): Result {
        var i = parms.inputData.getInt("INPUT",-1)
        Log.i(TAG, "dowork   $i")
        while (i<100){
            i++
        }
        Log.i(TAG, "dowork   $i")
        val data  = Data.Builder().putInt("INPUT", i).build();
        return Result.success(data)
    }

    companion object{
        val TAG = SampleWorker::class.java.name
    }
}