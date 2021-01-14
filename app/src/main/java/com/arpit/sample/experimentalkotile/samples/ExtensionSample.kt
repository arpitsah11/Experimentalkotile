package com.arpit.sample.experimentalkotile.samples

open class ExtensionSample {

    open val mValue  = 10;
    private val mName = ExtensionSample::class.java

    fun print(){
        println("print from $mName"+::print.name)
    }

    open fun print1(){
        println("print from $mName  $mValue "+::print1.name)
    }
}