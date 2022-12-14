package ir.ha.dummy.ui.fragment.mvvm_arch.live_data

import androidx.lifecycle.*
import ir.ha.dummy.model.UserModel
import java.util.*

class SimpleLiveDataChecker {

     var timer = Timer()
    private val user1 = UserModel("body",7,"Hsn Title" , 66)
    private val user2 = UserModel("body",12,"omid Title" , 66)
    val locationLiveData = MutableLiveData<String>()

    init {
        startCheck()
    }


    fun startCheck() {
        timer.schedule(object  : TimerTask() {
            override fun run() {
                locationLiveData.postValue("simple liveData - > test")
            } } , 1000)
    }


    fun getFullLiveDataTitle() : LiveData<String>{
        // map : taqir mide be on chizi k ma mikhayim masalan ma inja goftim biyad masalan 2 bar tekraresh kone
        val userNameByTransFormation = Transformations.map(locationLiveData) {
            "TransFormation LiveData -> $it  $it"
        }
        return userNameByTransFormation
    }

}