package com.arpit.sample.experimentalkotile.samples

class KotlinSingleton private constructor(args : Int){


    companion object {
        @Volatile
        private var mInstance : KotlinSingleton? = null

        fun getInstance(args: Int) : KotlinSingleton {
            val instance  = mInstance
            if(instance != null){
                return instance
            }
            return synchronized(this){
                var inst = mInstance
                if(inst != null){
                    inst
                }
                inst = KotlinSingleton(args)
                mInstance = inst
                inst
            }
        }
    }


}