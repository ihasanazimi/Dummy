package ir.ha.dummy.ui.fragment.mvvm_arch.lifecycleObserver

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ir.ha.dummy.R
import ir.ha.dummy.databinding.FragmentLifeCycleOwnerBinding
import ir.ha.dummy.utility.base.BaseFragment
import ir.ha.dummy.utility.extentions.showToast

class LifecycleOwnerFrg : BaseFragment(), MyLocationChecker.OnUpdate {

    lateinit var binding : FragmentLifeCycleOwnerBinding
    lateinit var  myLocationChecker : MyLocationChecker

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = getBinding(R.layout.fragment_life_cycle_owner,container!!)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        myLocationChecker = MyLocationChecker(this)

        // get life cycle AND set lifeCycle owner for this fragment
        lifecycle.addObserver(myLocationChecker)


    }

    override fun onLocation(location: String) {
        requireActivity().runOnUiThread{
            showToast(requireContext(),location)
        }
    }
}