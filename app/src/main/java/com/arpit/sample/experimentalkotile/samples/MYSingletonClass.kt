package com.arpit.sample.experimentalkotile.samples

class MYSingletonClass private constructor(private val value: Int, private val status: Boolean){

    fun print(){
        println("hello  $value $status" )
    }

    companion object: SingletonCreator<MYSingletonClass, Int, Boolean>(::MYSingletonClass)

}