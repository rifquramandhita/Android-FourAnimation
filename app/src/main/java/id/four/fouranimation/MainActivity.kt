package id.four.fouranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.four.animation.FadeIn
import id.four.animation.FadeOut
import id.four.animation.FlipHorizontal
import id.four.animation.FlipVertical
import id.four.animation.MoveLeftIn
import id.four.animation.MoveLeftOut
import id.four.animation.MoveRightIn
import id.four.animation.MoveRightOut
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
    lateinit var moveRightIn : MoveRightIn
    lateinit var moveRightOut : MoveRightOut
    lateinit var moveLeftIn : MoveLeftIn
    lateinit var moveLeftOut : MoveLeftOut

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
        binding.moveRightInB.setOnClickListener {
            viewModel.start(Animation.MOVE_RIGHT_IN)
        }
        binding.moveRightOutB.setOnClickListener {
            viewModel.start(Animation.MOVE_RIGHT_OUT)
        }
        binding.moveLeftInB.setOnClickListener {
            viewModel.start(Animation.MOVE_LEFT_IN)
        }

        binding.moveLeftOutB.setOnClickListener {
            viewModel.start(Animation.MOVE_LEFT_OUT)
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
                Animation.MOVE_RIGHT_IN->{
                    moveRightIn.end()
                }
                Animation.MOVE_RIGHT_OUT->{
                    moveRightOut.end()
                }
                Animation.MOVE_LEFT_IN->{
                    moveLeftIn.end()
                }
                Animation.MOVE_LEFT_OUT->{
                    moveLeftOut.end()
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
                        imageResource = R.drawable.icon
                    )
                    flipHorizontal.start()
                }

                Animation.FLIP_VERTICAL -> {
                    showPauseButton()
                    flipVertical = FlipVertical(
                        context = this,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    flipVertical.start()
                }
                Animation.ROTATE_CLOCK_WISE->{
                    showPauseButton()
                    rotateClockWise = RotateClockWise(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    rotateClockWise.start()
                }
                Animation.ROTATE_ANTI_CLOCK_WISE->{
                    showPauseButton()
                    rotateAntiClockWise = RotateAntiClockWise(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    rotateAntiClockWise.start()
                }
                Animation.FADE_IN -> {
                    showPauseButton()
                    fadeIn = FadeIn(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    fadeIn.start()
                }
                Animation.FADE_OUT -> {
                    showPauseButton()
                    fadeOut = FadeOut(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    fadeOut.start()
                }
                Animation.ZOOM_IN -> {
                    showPauseButton()
                    zoomIn = ZoomIn(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    zoomIn.start()
                }
                Animation.ZOOM_OUT->{
                    showPauseButton()
                    zoomOut = ZoomOut(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    zoomOut.start()
                }
                Animation.MOVE_RIGHT_IN->{
                    showPauseButton()
                    moveRightIn = MoveRightIn(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    moveRightIn.start()
                }
                Animation.MOVE_RIGHT_OUT->{
                    showPauseButton()
                    moveRightOut = MoveRightOut(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    moveRightOut.start()
                }
                Animation.MOVE_LEFT_IN->{
                    showPauseButton()
                    moveLeftIn = MoveLeftIn(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    moveLeftIn.start()
                }
                Animation.MOVE_LEFT_OUT->{
                    showPauseButton()
                    moveLeftOut = MoveLeftOut(
                        context = this@MainActivity,
                        imageView = binding.imageView,
                        imageResource = R.drawable.icon
                    )
                    moveLeftOut.start()
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