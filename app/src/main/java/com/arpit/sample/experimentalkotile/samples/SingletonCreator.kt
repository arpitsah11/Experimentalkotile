package com.arpit.sample.experimentalkotile.samples

open class SingletonCreator<out T : Any, in A, in B>(creator : (A, B)->T) {

    private var creator: ((A, B)->T) ? = creator
    @Volatile
    private var mInstance : T ?= null

    fun getInstance(arg :A, args2 :B): T{
        val instance = mInstance
        if(instance != null){
            return instance        }
        return synchronized(this){
            var inst = mInstance
            if(inst != null){
                inst
            }
            inst = creator!!(arg, args2)
            mInstance = inst
            inst
        }
    }
}