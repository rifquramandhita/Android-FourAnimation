package id.four.animation

import android.animation.Animator
import android.animation.AnimatorInflater
import android.animation.AnimatorListenerAdapter
import android.content.Context
import android.widget.ImageView

class FlipVertical {
    var flipAnimator: Animator
    var context: Context
    var imageView: ImageView
    var imageResource: Int
    var imageResourceMirrored: Int

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

        flipAnimator = AnimatorInflater.loadAnimator(context, R.animator.flip_vertical)

    }

    fun start() {
        var isMirror = false
        flipAnimator.setTarget(imageView)
        imageView.setImageResource(imageResource)
        flipAnimator.addListener(object : AnimatorListenerAdapter() {
            override fun onAnimationEnd(animation: Animator) {
                super.onAnimationEnd(animation)
                isMirror = !isMirror
                if (isMirror) {
                    imageView.setImageResource(imageResourceMirrored)
                } else {
                    imageView.setImageResource(imageResource)
                }
                flipAnimator.start()
            }
        })

        flipAnimator.start()
    }

    fun end() {
        if (flipAnimator.isRunning) {
            flipAnimator.cancel()
        }

        flipAnimator.removeAllListeners()
        flipAnimator.setTarget(null)
    }
}