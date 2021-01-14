package com.arpit.sample.experimentalkotile.samples

class ExtensionChild : ExtensionSample() {

    val mName = ExtensionChild::class.java
    override val mValue = 20;

    override fun print1() {
        println("print from $mName $mValue"+::print1.name)
    }

    fun print0(){
        println("print from $mName $mValue"+::print0.name)
    }
    

}