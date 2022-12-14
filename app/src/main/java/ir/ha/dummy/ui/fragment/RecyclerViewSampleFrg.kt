package ir.ha.dummy.ui.fragment

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import ir.ha.dummy.R
import ir.ha.dummy.databinding.FragmentRecyclerViewSampleBinding
import ir.ha.dummy.model.FakeDataModel
import ir.ha.dummy.model.adapters.FakeDataAdapter
import ir.ha.dummy.repo.FakeDataGenerator
import ir.ha.dummy.utility.base.BaseFragment

class RecyclerViewSampleFrg : BaseFragment<FragmentRecyclerViewSampleBinding>(){
    override val layoutId: Int
        get() = R.layout.fragment_recycler_view_sample

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.rv.layoutManager = LinearLayoutManager(requireContext())

        val adapter = FakeDataAdapter(object : FakeDataAdapter.FakeDataEventListener{
            override fun onFakeDataItemClickListener(fakedata: FakeDataModel) {
                Toast.makeText(requireContext(), fakedata.fileName, Toast.LENGTH_SHORT).show()
            }
        })
        adapter.setNewList(FakeDataGenerator.getDataFakeGenerator().toList())
        binding.rv.adapter = adapter
    }



}