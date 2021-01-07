
package com.lefarmico.trainingapp.utilites

import android.content.Context
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import kotlin.math.absoluteValue

open class OnSwipeListener(context: Context) : View.OnTouchListener {

    private val gestureDetector: GestureDetector

    companion object {
        private const val swipeVelocityThreshold = 100
        private const val swipeThreshold = 100
    }

    init {
        gestureDetector = GestureDetector(context, GestureListener())
    }

    override fun onTouch(v: View?, event: MotionEvent?): Boolean {
        v?.performClick()
        return gestureDetector.onTouchEvent(event)
    }

    private inner class GestureListener : GestureDetector.SimpleOnGestureListener() {

        override fun onDown(e: MotionEvent?): Boolean {
            return true
        }

        override fun onFling(
            e1: MotionEvent?,
            e2: MotionEvent?,
            velocityX: Float,
            velocityY: Float
        ): Boolean {
            val diffX = e2?.x?.minus(e1?.x!!)
            val diffY = e2?.y?.minus(e1?.y!!)
            if (diffX!!.absoluteValue > diffY!!.absoluteValue) {
                if (diffX.absoluteValue > swipeThreshold && velocityX.absoluteValue > swipeVelocityThreshold) {
                    if (diffX > 0) {
                        onSwipeRight()
                    } else
                        onSwipeLeft()
                }
            } else if (diffY.absoluteValue > diffX.absoluteValue) {
                if (diffY.absoluteValue > swipeThreshold && velocityY.absoluteValue > swipeVelocityThreshold) {
                    if (diffY > 0) {
                        onSwipeDown()
                    } else
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
