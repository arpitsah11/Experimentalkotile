package com.arpit.sample.experimentalkotile.samples

class SClass private constructor(str1 : String, str2: String){


    companion object: SHolder<SClass, String, String>(::SClass)
}