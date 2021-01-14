package com.arpit.sample.experimentalkotile.samples

class LongestSubstring {

    fun main(args : Array<String>){
        val caller = LongestSubstring()
        caller.lengthOfLongestSubstring("abcabcbb")
    }


    fun lengthOfLongestSubstring(str : String) : Int{
        var window =""
        var i = 0;
        var max =0
        while(i<str.length){
            if(window.contains(str[i])){
                var m = 0
                while (m <window.length){
                    if(window[m] == str[i]){
                        window = ""+window.substring(max+1)
                        max -= m+1
                    }else{
                        m++
                    }
                }
            }
            window = window+""+str[i]
            max ++;
            i++
        }
        return max
    }
}