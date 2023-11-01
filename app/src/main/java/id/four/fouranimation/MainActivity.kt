package id.four.fouranimation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import id.four.animation.FlipHorizontal
import id.four.animation.FlipVertical
import id.four.animation.RotateClockWise
import id.four.fouranimation.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    lateinit var viewModel: MainViewModel

    lateinit var flipHorizontal: FlipHorizontal
    lateinit var flipVertical: FlipVertical
    lateinit var rotateClockWise: RotateClockWise

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

        binding.rotateRightB.setOnClickListener {
            viewModel.start(Animation.ROTATE_CLOCK_WISE)
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