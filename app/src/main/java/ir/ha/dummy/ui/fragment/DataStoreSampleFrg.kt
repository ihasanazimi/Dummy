package ir.ha.dummy.ui.fragment

import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.lifecycle.lifecycleScope
import ir.ha.dummy.R
import ir.ha.dummy.dataStore
import ir.ha.dummy.databinding.FragmentDataStoreSampleBinding
import ir.ha.dummy.utility.base.BaseFragment
import kotlinx.coroutines.flow.first

class DataStoreSampleFrg : BaseFragment<FragmentDataStoreSampleBinding>() {
    override val layoutId: Int get() = R.layout.fragment_data_store_sample


    override fun onResume() {
        super.onResume()

        lifecycleScope.launchWhenResumed {
            binding.input.setText(readFromPref("test_key"))
        }


        binding.btn.setOnClickListener{
            binding.input.setText(binding.input.text.toString())
            lifecycleScope.launchWhenResumed {
                saveInput("test_key" , binding.input.text.toString())
            }
        }

    }

    private suspend fun readFromPref(key : String ) : String?{
        val dataStoreKey = stringPreferencesKey(key)
        val preference = requireContext().dataStore.data.first()
        return preference[dataStoreKey]
    }


    // // write into data Store
    private suspend fun saveInput(key : String, value : String) {
        val dataStoreKey = stringPreferencesKey(key)
        requireContext().dataStore.edit { settings ->
            settings[dataStoreKey] = value/* this is value */
        }
    }


    override fun onDestroy() {
        super.onDestroy()

    }


}