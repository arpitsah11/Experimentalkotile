package com.arpit.sample.experimentalkotile

import android.app.IntentService
import android.content.Intent
import android.os.Handler
import android.os.HandlerThread
import android.util.Log
import androidx.core.os.postDelayed

class SampleIntentService : IntentService(SampleIntentService::class.java.name) {

    lateinit var handler: Handler
    lateinit var th: HandlerThread


    override fun onCreate() {
        Log.i(TAG, "ON CREATE")
        th = HandlerThread(TAG);
        th.start()
        handler = Handler(th.looper)
        Log.i(TAG," "+ Thread.currentThread().id)
        super.onCreate()
    }

    override fun onHandleIntent(intent: Intent?) {
        Log.i(TAG,"  onHandleIntent "+ Thread.currentThread().id)
        when (intent?.action) {
            INTENT1 -> handleIntent1()
            INTENT2 -> handleIntent2()
        }
    }


    private fun handleIntent2() {
        Log.i(TAG, "handleIntent2 start")
        handler.post {
            Log.i(TAG,"  thread "+ Thread.currentThread().id)
            var i = 0
            Log.i(TAG, "handleIntent2 $i")
            while (i < 50000) {
                i++
            }
            Log.i(TAG, "handleIntent2 $i")
        }
        Log.i(TAG, "handleIntent2 complete")
    }

    private fun handleIntent1() {
        Log.i(TAG, "handleIntent1 start")
        handler.post {
            Log.i(TAG,"  thread "+ Thread.currentThread().id)
            var i = 0
            Log.i(TAG, "handleIntent1 $i")
            while (i < 500000) {
                i++
            }
            Log.i(TAG, "handleIntent1 $i")
        }
        Log.i(TAG, "handleIntent1 complete")
    }

    override fun onDestroy() {
        Log.i(TAG," "+ Thread.currentThread().id)
        Log.i(TAG, "calling quit")
        handler.removeCallbacksAndMessages(null)
        th.quitSafely()
        Log.i(TAG, "ON DESTROY")
        super.onDestroy()
    }


    fun trial(){
        val arr = arrayOf(1,2,3)
        abc@ for (item in arr){
            if(item == 1)
            break@abc
        }
    }

    companion object {
        val TAG = SampleIntentService::class.java.name
        const val INTENT1 = "intent1"
        const val INTENT2 = "intent2"
    }
}