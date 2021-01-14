package com.arpit.sample.experimentalkotile

import android.content.Context
import android.util.Log
import androidx.work.Data
import androidx.work.Worker
import androidx.work.WorkerParameters

class SampleWorker(context: Context,val parms: WorkerParameters) : Worker(context, parms) {

    override fun doWork(): Result {
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