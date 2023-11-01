package id.four.animation

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class FlipHorizontal {
    var animation: Animation
    var context: Context
    var imageView: ImageView
    var imageResource: Int
    var imageResourceMirrored: Int
    var isEnd : Boolean = true

    constructor(
        context: Context,
        imageView: ImageView,
        imageResource: Int,
        imageResourceMirrored: Int
    ) {
        this.context = context
        this.imageView = imageView
        this.imageResource = imageResource
        this.imageResourceMirrored = imageResourceMirrored

        animation = AnimationUtils.loadAnimation(context, R.anim.flip_horizontal)

    }

    fun start() {
        isEnd = false
        var isMirror = false
        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(animation: Animation?) {
                if (isMirror) {
                    imageView.setImageResource(imageResourceMirrored)
                } else {
                    imageView.setImageResource(imageResource)
                }
            }

            override fun onAnimationEnd(animation: Animation?) {
                if(!isEnd){
                    isMirror = !isMirror
                    imageView.startAnimation(animation)
                }
            }

            override fun onAnimationRepeat(animation: Animation?) {}
        })
        imageView.startAnimation(animation)
    }

    fun end() {
        isEnd = true
        imageView.clearAnimation()
    }
}