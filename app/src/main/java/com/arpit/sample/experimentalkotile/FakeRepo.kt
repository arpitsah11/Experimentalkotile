package com.arpit.sample.experimentalkotile

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.*
import kotlinx.coroutines.channels.*
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FakeRepo: IRepo {

    private val mutableLiveData = MutableLiveData<String>()
    val liveDataChannel: LiveData<String> = mutableLiveData
    private val flowData = MutableLiveData<Int>()
    val liveDataFlow: LiveData<Int> = flowData
    private val myscope = CoroutineScope(Dispatchers.Main + SupervisorJob())

    val tester = "aaaa"

    private suspend fun getAllDataViaFlow(): Flow<Int> {
        return flow {
            var i = 0
            while (i < 10) {
                Log.i(TAG, "flow called")
                delay(500)
                emit(i)
                i++
            }
        }
    }

    override fun flowWork() {
        Log.i(TAG, "flowCollector")
        runBlocking {
            Log.i(TAG, "flowCollector run blocking")
            val job = launch {
                val flowcollector = getAllDataViaFlow();
                Log.i(TAG, "flowCollector run launch")
                flowcollector.collect {
                    flowData.postValue(it * 10)
                }
                Log.i(TAG, "flowCollector run launch end")
            }
            val job1 = launch {
                withContext(Dispatchers.Default) {
                    delay(2000)
                }
            }
            job1.join()
            job.cancel()
            Log.i(TAG, "flowCollector run blocking end")
        }
        Log.i(TAG, "flowCollector end")
    }

    private suspend fun getAllDataViaChannel(channel: SendChannel<Int>) {
        Log.i(TAG, "getAllDataViaChannel")
        var i = 0
        while (i < 10) {
            delay(50)
            channel.send(i)
            Log.i(TAG, "channel called $i")
            i++
        }
    }

    private suspend fun getAllDataViaChannel1()  = myscope.produce<Int>{
        Log.i(TAG, "getAllDataViaChannel")
        var i = 0
        while (i < 10) {
            delay(50)
            send(i)
            Log.i(TAG, "channel called $i")
            i++
        }
    }

    private suspend fun receiveAndWorkFortrial(channel: ReceiveChannel<Int>) {
        channel.consumeEach {
            delay(100)
            Log.i(TAG, "receiveAndWorkFortrial $it")
            mutableLiveData.postValue("$" + it)
        }
    }

    private suspend fun receiveAndWork(channel: ReceiveChannel<Int>) {
        for (value in channel) {
            delay(100)
            Log.i(TAG, "receiveAndWork $value")
            mutableLiveData.postValue("$" + value)
        }
    }

    private suspend fun receiveAndWork2(channel: ReceiveChannel<Int>) {
        for (value in channel) {
            delay(50)
            Log.i(TAG, "receiveAndWork2 $value")
            mutableLiveData.postValue("$" + value)
        }
    }


    override fun channelWork() {
        val channel = Channel<Int>(Channel.UNLIMITED)
        Log.i(TAG, "channelWork")
        runBlocking {
            launch {
                getAllDataViaChannel(channel)
            }
            launch { receiveAndWork(channel) }
            launch { receiveAndWork2(channel) }
        }
    }

    override fun getDataForChannel(): LiveData<String> {
        return liveDataChannel
    }

    override fun getDataForFlow(): LiveData<Int> {
        return flowData
    }

    fun sample(){
        GlobalScope.launch {

        }
    }

    companion object {
        const val TAG = "myarpit"
    }

    override fun getIdentity(): String {
        return this.javaClass.name
    }

    fun trial(){

        myscope.launch {
            receiveAndWorkFortrial(getAllDataViaChannel1())
        }
        myscope.cancel()
    }
}