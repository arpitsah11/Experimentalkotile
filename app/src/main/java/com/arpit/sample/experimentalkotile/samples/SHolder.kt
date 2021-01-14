package com.arpit.sample.experimentalkotile.samples

open class SHolder<out T: Any, in A, B>(creator : (A, B)->T){

    private var creator: ((A, B)->T) = creator

    @Volatile
    private var Instance : T? = null

    fun getInstance(arg : A, arg1: B): T{
        val instance = Instance
        if(instance != null){
            return instance
        }
        synchronized(this){
            var ins = Instance
            if(ins != null){
                return ins
            }
            ins = creator!!(arg, arg1).also {
                Instance =it
            }
            return ins
        }
    }

}