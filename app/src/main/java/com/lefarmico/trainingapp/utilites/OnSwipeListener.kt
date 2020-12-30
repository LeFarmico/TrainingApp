package com.lefarmico.trainingapp.utilites

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.abs
import kotlin.math.absoluteValue

open class OnSwipeListener(context: Context) : View.OnTouchListener {

    private val gestureDetector : GestureDetector

    companion object{
        private val SWIPE_VELOCITY_THRESHOLD = 100
        private val SWIPE_THRESHOLD = 100
    }

    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {


        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onFling(e1: MotionEvent?, e2: MotionEvent?, velocityX: Float, velocityY: Float): Boolean {
            val diffX = e2?.x?.minus(e1?.x!!)
            val diffY = e2?.y?.minus(e1?.y!!)
            if(diffX!!.absoluteValue > diffY!!.absoluteValue){
                if(diffX.absoluteValue > SWIPE_THRESHOLD && velocityX.absoluteValue > SWIPE_VELOCITY_THRESHOLD){
                    if (diffX > 0) {
                        onSwipeRight()
                    }
                    else
                        onSwipeLeft()
                }
            }else if(diffY!!.absoluteValue > diffX!!.absoluteValue){
                if (diffY.absoluteValue > SWIPE_THRESHOLD && velocityY.absoluteValue > SWIPE_VELOCITY_THRESHOLD){
                    if (diffY > 0){
                        onSwipeDown()
                    }else
                        onSwipeTop()
                }
            }

            return true


        }
    }

    open fun onSwipeTop() {}

    open fun onSwipeDown() {}

    open fun onSwipeLeft() {}

    open fun onSwipeRight() {}
}