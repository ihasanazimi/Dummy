package ir.ha.dummy.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import ir.ha.dummy.R
import ir.ha.dummy.databinding.ActivityMainBinding
import ir.ha.dummy.model.FakeDataModel
import ir.ha.dummy.ui.fragment.*
import ir.ha.dummy.ui.fragment.firebase.FirebaseCloudMessagingFrg
import ir.ha.dummy.ui.fragment.flow.FlowFrg
import ir.ha.dummy.ui.fragment.httpSamples.RequestSampleFrg
import ir.ha.dummy.ui.fragment.material.MaterialViews
import ir.ha.dummy.ui.fragment.mvvm_arch.MvvmContainerFrg
import ir.ha.dummy.ui.fragment.mvvm_rx.MVVMRxJavaFrg
import ir.ha.dummy.ui.fragment.navigation_component.NavComponentActivity
import ir.ha.dummy.ui.fragment.rxjava.RxJavaContainer
import ir.ha.dummy.ui.fragment.services.ServicesFrg
import ir.ha.dummy.ui.fragment.viewPager.ViewPagerSampleFrg
import ir.ha.dummy.ui.sample.SamplePrjActivity
import ir.ha.dummy.utility.base.BaseActivity
import ir.ha.dummy.utility.extentions.addFragmentByAnimation
import ir.ha.dummy.utility.extentions.showToast

//@AndroidEntryPoint
class MainActivity : BaseActivity<ActivityMainBinding>(), View.OnClickListener {

    override val layoutId: Int get() = R.layout.activity_main

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.imageLoaderBtn.setOnCheckedChangeListener { compoundButton, b -> compoundButton.isChecked = b }
        binding.imageLoaderBtn.setOnClickListener(this)
        binding.bannerSliderBtn.setOnClickListener(this)
        binding.recyclerViewSampleBtn.setOnClickListener(this)
        binding.FragmentSample.setOnClickListener(this)
        binding.materialDesign.setOnClickListener(this)
        binding.lottieAnimationView.setOnClickListener(this)
        binding.multiThreadingBtn.setOnClickListener(this)
        binding.retrofitOkHttpBtn.setOnClickListener(this)
        binding.btnSharedPreferences.setOnClickListener(this)
        binding.btnDataStorePreferences.setOnClickListener(this)
        binding.btnRoomDb.setOnClickListener(this)
        binding.btnBroadCastReceiverSample.setOnClickListener(this)
        binding.btnMediaPlayer.setOnClickListener(this)
        binding.btnVideoPlayer.setOnClickListener(this)
        binding.btnCreateNotification.setOnClickListener(this)
        binding.btnServices.setOnClickListener(this)
        binding.btnRxJava.setOnClickListener(this)
        binding.btnEventBus.setOnClickListener(this)
        binding.btnMvvmRx.setOnClickListener(this)
        binding.btnNavComponent.setOnClickListener(this)
        binding.btnNavComponent.setOnClickListener(this)
        binding.btnMVVM.setOnClickListener(this)
        binding.btnFirbase.setOnClickListener(this)
        binding.btnHilt.setOnClickListener(this)
        binding.sampleRrj.setOnClickListener(this)
        binding.flow.setOnClickListener(this)
    }

    override fun onClick(v: View?) {

        binding.chipGroup.clearCheck()

        when(v?.id){
            R.id.imageLoaderBtn -> {
                binding.imageLoaderBtn.isChecked = true
                addFragmentByAnimation(LoadImagesSampleFrg(),"loadImagesTag",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false
                )
            }


            R.id.bannerSliderBtn ->{
                binding.bannerSliderBtn.isChecked = true
                addFragmentByAnimation(ViewPagerSampleFrg(),"BannerSliderTag",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false
                )
            }


            R.id.recyclerViewSampleBtn -> {
                binding.recyclerViewSampleBtn.isChecked = true
                addFragmentByAnimation(RecyclerViewSampleFrg(),"RecyclerViewSampleFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false
                )
            }


            R.id.FragmentSample -> {
                binding.FragmentSample.isChecked = true
                /** how to pass data model into fragment by newInstance method...  */
                val fakeDataModel = FakeDataModel("Hsn", "https://post.medicalnewstoday.com/wp-content/uploads/sites/3/2020/02/326012_1100-800x825.jpg")
                val frg = SampleOfFrg().newInstance(fakeDataModel)
                addFragmentByAnimation(frg,"SampleOfFragment",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false
                )
            }


            R.id.materialDesign -> {
                binding.materialDesign.isChecked = true
                addFragmentByAnimation(MaterialViews(),"ToolbarFrgSample",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.lottieAnimationView -> {
                binding.lottieAnimationView.isChecked = true
                addFragmentByAnimation(AnimationsFrg(),"AnimationsFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false) // test
            }

            R.id.retrofitOkHttpBtn -> {
                binding.retrofitOkHttpBtn.isChecked = true
                addFragmentByAnimation(RequestSampleFrg(),"RequestFrgSample",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_shared_preferences -> {
                binding.btnSharedPreferences.isChecked = true
                addFragmentByAnimation(SharedPreferencesSampleFrg(),"SharedPreferencesSampleClass",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_data_store_preferences -> {
                binding.btnDataStorePreferences.isChecked = true
                addFragmentByAnimation(DataStoreSampleFrg(),"DataStoreSampleFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_room_db -> {
                binding.btnRoomDb.isChecked = true
                addFragmentByAnimation(RoomDBSamplerFrg(),"RoomDBSamplerFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_broadCast_receiver_sample -> {
                binding.btnBroadCastReceiverSample.isChecked = true
                addFragmentByAnimation(BroadcastReceiverSampleFrg(),"BroadcastReceiverSampleFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_media_player -> {
                binding.btnMediaPlayer.isChecked = true
                addFragmentByAnimation(MediaPlayerFrg(),"MediaPlayerFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }


            R.id.btn_video_player -> {
                binding.btnVideoPlayer.isChecked = true
                addFragmentByAnimation(VideoPlayerFrg(),"VideoPlayerFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }
            R.id.btn_create_notification -> {
                binding.btnCreateNotification.isChecked = true
                addFragmentByAnimation(NotificationFrg(),"NotificationFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_services -> {
                binding.btnServices.isChecked = true
                addFragmentByAnimation(ServicesFrg(),"ServicesFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_rxJava -> {
                binding.btnRxJava.isChecked = true
                addFragmentByAnimation(RxJavaContainer(),"RxJavaContainer",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_eventBus -> {
                binding.btnEventBus.isChecked = true
                addFragmentByAnimation(EventBusFrg(),"EventBusFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            R.id.btn_mvvm_rx -> {
                binding.btnMvvmRx.isChecked = true
                addFragmentByAnimation(MVVMRxJavaFrg(),"MVVMRxJavaFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }


            R.id.btn_nav_component -> {
                binding.btnNavComponent.isChecked = true
                startActivity(Intent(this, NavComponentActivity::class.java))
            }


            R.id.btn_MVVM -> {
                binding.btnMVVM.isChecked = true
                addFragmentByAnimation(MvvmContainerFrg(),"MvvmContainerFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }


            R.id.btn_firbase -> {
                binding.btnFirbase.isChecked = true
                addFragmentByAnimation(FirebaseCloudMessagingFrg(),"FirebaseFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }


            R.id.btn_hilt -> {
//                binding.btnHilt.isChecked = true
//                addFragmentByAnimation(HiltFrg(),"HiltFrg",
//                    addToBackStack = true,
//                    customAnimations = true,
//                    containerViewId = R.id.mainFrame,
//                    commitAllowingStateLoss = false)
            }

            R.id.sampleRrj ->{
                binding.sampleRrj.isChecked = true
                startActivity(Intent(this@MainActivity, SamplePrjActivity::class.java))
            }



            R.id.multiThreadingBtn -> {

                binding.multiThreadingBtn.isChecked = true

                showToast(this,"output in Logcat..")

                // solution 1
                MultiThreadingClass().start() // outPut -> multiThreading current threadName in Log.e / tag = hsn


                // solution 2
                Thread(object  : MyRunnableThread() {
                    override fun run() {
                        // done superClass code block
                        super.run() // outPut -> multiThreading current threadName in Log.e / tag = hsn
                    }
                }).start()


                // solution 3 by lambda
                Thread {
                    Log.e("hsn", "solution 3 by lambda  ->  " + Thread.currentThread().name)
                }.start()

            }

            R.id.flow -> {
                binding.flow.isChecked = true
                addFragmentByAnimation(FlowFrg(),"FlowFrg",
                    addToBackStack = true,
                    customAnimations = true,
                    containerViewId = R.id.mainFrame,
                    commitAllowingStateLoss = false)
            }

            else -> { showToast(this,"???? ???? ???????????? ???????? ??????")} }
    }
}