package id.four.animation

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class FlipVertical {
    var animation: Animation
    var context: Context
    var imageView: ImageView
    var imageResource: Int
    var imageResourceMirrored: Int
    var isEnd = true

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

        animation = AnimationUtils.loadAnimation(context, R.anim.flip_vertical)

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