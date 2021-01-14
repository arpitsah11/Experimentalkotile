package com.arpit.sample.experimentalkotile.samples

class TryExtension {

    fun trial(){
        /*val child = ExtensionChild()
        println(child.mName)

        child.print0()
        child.print()*/

        /*val parent = ExtensionSample()
        print(parent.mValue)
        parent.print1()
        parent.print()*/

        val childINParent : ExtensionSample = ExtensionChild()
        childINParent.print1()
        childINParent.printlocal()

        val parent = ExtensionSample()
        parent.print1()
        parent.print()
        parent.printlocal()

        val child = ExtensionChild()
        child.printabc()
    }

    fun ExtensionSample.print(){
        println("extension called print")
    }

    fun ExtensionSample.printlocal(){
        println("extension called print")
    }

    fun ExtensionChild.printabc(){
        println("extension called print1")
    }

}
