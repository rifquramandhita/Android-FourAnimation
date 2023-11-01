package id.four.animation

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class FlipHorizontal {
    var animation: Animation
    var animationMirrored : Animation
    var context: Context
    var imageView: ImageView
    var imageResource: Int
    var imageResourceMirrored: Int
    var isEnd : Boolean = false

    var isMirror = false

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
        animationMirrored = AnimationUtils.loadAnimation(context, R.anim.flip_horizontal_mirrored)

        animation.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                    imageView.setImageResource(imageResource)
            }

            override fun onAnimationEnd(p0: Animation?) {
                if(!isEnd){
                    imageView.startAnimation(animationMirrored)
                }
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })

        animationMirrored.setAnimationListener(object : Animation.AnimationListener {
            override fun onAnimationStart(p0: Animation?) {
                imageView.setImageResource(imageResourceMirrored)
            }

            override fun onAnimationEnd(p0: Animation?) {
                if(!isEnd){
                    imageView.startAnimation(animation)
                }
            }

            override fun onAnimationRepeat(p0: Animation?) {}
        })

    }

    fun start() {
        imageView.startAnimation(animation)
    }

    fun end() {
        isEnd = true
        imageView.clearAnimation()
    }
}