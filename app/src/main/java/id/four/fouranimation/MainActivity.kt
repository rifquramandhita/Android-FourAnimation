package id.four.fouranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.four.animation.FadeIn
import id.four.animation.FadeOut
import id.four.animation.FlipHorizontal
import id.four.animation.FlipVertical
import id.four.animation.RotateAntiClockWise
import id.four.animation.RotateClockWise
import id.four.animation.ZoomIn
import id.four.animation.ZoomOut
import id.four.fouranimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    lateinit var flipHorizontal: FlipHorizontal
    lateinit var flipVertical: FlipVertical
    lateinit var rotateClockWise: RotateClockWise
    lateinit var rotateAntiClockWise: RotateAntiClockWise
    lateinit var fadeIn: FadeIn
    lateinit var fadeOut: FadeOut
    lateinit var zoomIn: ZoomIn
    lateinit var zoomOut : ZoomOut

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel = MainViewModel()

        initListener()
        initObserver()
    }

    private fun initListener(){
        binding.flipHorizontalB.setOnClickListener {
            viewModel.start(Animation.FLIP_HORIZONTAL)
        }

        binding.flipVerticalB.setOnClickListener {
            viewModel.start(Animation.FLIP_VERTICAL)
        }

        binding.rotateClockWiseB.setOnClickListener {
            viewModel.start(Animation.ROTATE_CLOCK_WISE)
        }

        binding.rotateAntiClockWiseB.setOnClickListener {
            viewModel.start(Animation.ROTATE_ANTI_CLOCK_WISE)
        }

        binding.fadeInB.setOnClickListener {
            viewModel.start(Animation.FADE_IN)
        }

        binding.fadeOutB.setOnClickListener {
            viewModel.start(Animation.FADE_OUT)
        }

        binding.zoomInB.setOnClickListener {
            viewModel.start(Animation.ZOOM_IN)
        }

        binding.zoomOutB.setOnClickListener {
            viewModel.start(Animation.ZOOM_OUT)
        }

        binding.pauseB.setOnClickListener {
            when(viewModel._isStart.value){
                Animation.FLIP_HORIZONTAL ->{
                    flipHorizontal.end()
                }
                Animation.FLIP_VERTICAL ->{
                    flipVertical.end()
                }
                Animation.ROTATE_CLOCK_WISE->{
                    rotateClockWise.end()
                }
                Animation.ROTATE_ANTI_CLOCK_WISE->{
                    rotateAntiClockWise.end()
                }
                Animation.FADE_IN-> {
                    fadeIn.end()
                }
                Animation.FADE_OUT->{
                    fadeOut.end()
                }
                Animation.ZOOM_IN->{
                    zoomIn.end()
                }
                Animation.ZOOM_OUT->{
                    zoomOut.end()
                }
                else ->{}
            }
            viewModel.pause()
        }
    }

    private fun initObserver(){
        viewModel._isStart.observe(this){
            when(it){
                Animation.FLIP_HORIZONTAL -> {
                    showPauseButton()
                    flipHorizontal = FlipHorizontal(
                        context = this,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher,
                        imageResourceMirrored = R.mipmap.ic_launcher
                    )
                    flipHorizontal.start()
                }

                Animation.FLIP_VERTICAL -> {
                    showPauseButton()
                    flipVertical = FlipVertical(
                        context = this,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher,
                        imageResourceMirrored = R.mipmap.ic_launcher
                    )
                    flipVertical.start()
                }
                Animation.ROTATE_CLOCK_WISE->{
                    showPauseButton()
                    rotateClockWise = RotateClockWise(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher
                    )
                    rotateClockWise.start()
                }
                Animation.ROTATE_ANTI_CLOCK_WISE->{
                    showPauseButton()
                    rotateAntiClockWise = RotateAntiClockWise(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher
                    )
                    rotateAntiClockWise.start()
                }
                Animation.FADE_IN -> {
                    showPauseButton()
                    fadeIn = FadeIn(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher
                    )
                    fadeIn.start()
                }
                Animation.FADE_OUT -> {
                    showPauseButton()
                    fadeOut = FadeOut(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher
                    )
                    fadeOut.start()
                }
                Animation.ZOOM_IN -> {
                    showPauseButton()
                    zoomIn = ZoomIn(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher
                    )
                    zoomIn.start()
                }
                Animation.ZOOM_OUT->{
                    showPauseButton()
                    zoomOut = ZoomOut(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.mipmap.ic_launcher
                    )
                    zoomOut.start()
                }
                Animation.PAUSE -> {
                    showPlayButton()
                }
            }
        }
    }

    fun showPlayButton(){
        binding.buttonPlayCl.visibility = View.VISIBLE
        binding.buttonPauseCl.visibility = View.GONE
    }

    fun showPauseButton(){
        binding.buttonPlayCl.visibility = View.GONE
        binding.buttonPauseCl.visibility = View.VISIBLE
    }
}