package com.arpit.sample.experimentalkotile

import android.content.Context
import android.util.Log
import androidx.startup.Initializer
import androidx.work.Configuration
import androidx.work.WorkManager

class CustomInitializerWorkManager : Initializer<WorkManager> {
    override fun create(context: Context): WorkManager {
        Log.i("initalizer","oncreate")
        WorkManager.initialize(context, Configuration.Builder().build())
        return WorkManager.getInstance(context);
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        Log.i("initalizer","dependencies")
        return mutableListOf()
    }


}