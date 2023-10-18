package id.four.fouranimation

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class MainViewModel : ViewModel() {

    val _isStart = MutableLiveData<Animation>()

    init {
        _isStart.postValue(Animation.PAUSE)
    }

    fun start(animation : Animation){
        _isStart.postValue(animation)
    }

    fun pause(){
        _isStart.postValue(Animation.PAUSE)
    }

}