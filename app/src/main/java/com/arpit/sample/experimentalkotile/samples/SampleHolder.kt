package com.arpit.sample.experimentalkotile.samples

open class SampleHolder<out T : Any , in A> (creator : (A)->T) {
    private var creator : ((A)->T) ? = creator

    @Volatile
    private var mInstance : T? = null

    fun getInstance(arg : A): T{
        val instance = mInstance
        if(instance != null){
            return instance
        }
        return synchronized(this){
            var ins = mInstance
            if(ins != null){
                return ins
            }
            ins = creator!!(arg).also { mInstance=it }
            return ins
        }
    }
}