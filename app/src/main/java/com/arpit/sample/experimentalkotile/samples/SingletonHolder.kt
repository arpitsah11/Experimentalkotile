package com.arpit.sample.experimentalkotile.samples

open class SingletonHolder<out T: Any, in A>(creator : (A) ->T){

    private var creator : ((A)->T) ? = creator
    @Volatile
    private var INSTANCE : T? = null
    fun getInstance(arg : A): T{
        val _instance = INSTANCE
        if(_instance != null){
            return _instance
        }
        return synchronized(this){
            var inst = INSTANCE
            if(inst != null){
                inst
            }
            inst = creator!!(arg)
            creator = null
            INSTANCE = inst
            inst
        }
    }
}