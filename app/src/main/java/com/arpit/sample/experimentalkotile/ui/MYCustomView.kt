package com.arpit.sample.experimentalkotile.ui

import android.content.Context
import android.util.AttributeSet
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import com.arpit.sample.experimentalkotile.R

class MYCustomView(context: Context, attrs: AttributeSet) : AppCompatButton(context, attrs) {

    private var state: Int = STATE_UNKNOWN

    fun setCustomState(state: Int) {
        Log.i("myarpit", "setCustomState  "+state)
        this.state = state;
        refreshDrawableState()
    }

    override fun onCreateDrawableState(extraSpace: Int): IntArray {
        Log.i("myarpit", "onCreateDrawableState")
        val drawableState = super.onCreateDrawableState(extraSpace + 2)
        when (state){
            STATE_ACTIVE -> mergeDrawableStates(drawableState, state_active)
            STATE_INACTIVE -> mergeDrawableStates(drawableState, state_inactive)
            STATE_AVAILABLE -> mergeDrawableStates(drawableState, state_available)
            STATE_UNAVAILABLE -> mergeDrawableStates(drawableState, state_unavailable)
            else -> mergeDrawableStates(drawableState, state_unknown)
        }
        return drawableState
    }

    fun getState(): Int {
        return state
    }

    companion object {
        const val STATE_AVAILABLE = 1;
        const val STATE_UNAVAILABLE = 2;
        const val STATE_ACTIVE = 3;
        const val STATE_INACTIVE = 4;
        const val STATE_UNKNOWN = 5;

        private val state_active = intArrayOf(R.attr.active)
        private val state_available = intArrayOf(R.attr.available)
        private val state_inactive =intArrayOf( R.attr.inactive)
        private val state_unavailable = intArrayOf(R.attr.unavailable)
        private val state_unknown = intArrayOf(R.attr.unknown)


    }

}