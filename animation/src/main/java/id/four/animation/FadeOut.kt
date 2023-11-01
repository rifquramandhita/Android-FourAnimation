package id.four.animation

import android.content.Context
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView


class FadeOut {
    var animation: Animation
    var context: Context
    var imageView: ImageView
    var imageResource: Int

    constructor(
        context: Context,
        imageView: ImageView,
        imageResource: Int,
    ) {
        this.context = context
        this.imageView = imageView
        this.imageResource = imageResource

        animation = AnimationUtils.loadAnimation(
            context,
            R.anim.fade_out
        )
        imageView.setImageResource(imageResource)
    }

    fun start() {
        imageView.startAnimation(animation)
    }

    fun end() {
        imageView.clearAnimation()
    }
}