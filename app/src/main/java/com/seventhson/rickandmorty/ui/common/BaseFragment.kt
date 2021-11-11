package com.seventhson.rickandmorty.ui.common

import android.app.Dialog
import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.seventhson.rickandmorty.data.sharedPreferences.SharedPrefs
import com.seventhson.rickandmorty.utils.DialogUtil
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import com.seventhson.rickandmorty.utils.showCustomMessage
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject

abstract class BaseFragment<V: ViewBinding>(contentLayoutId: Int) : Fragment(contentLayoutId) {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    private val progressDialog: Dialog by lazy { DialogUtil().getLoadingDialog(requireActivity()) }

    lateinit var binding: V

    override fun onAttach(context: Context) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }

    override fun onStop() {
        super.onStop()
        if (progressDialog.isShowing) progressDialog.dismiss()
    }

    fun manageLoadingDialog(mustShow: Boolean) {
        if (mustShow)
            progressDialog.show()
        else
            progressDialog.dismiss()
    }

    fun logout() {

    }

    fun handleError(it: Map<Int, String>) {
        requireActivity().showCustomMessage(it.values.first(), Snackbar.LENGTH_LONG)
        when (it.keys.first()) {
            401 -> logout()
        }
    }

    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProvider(this@BaseFragment, this).get(T::class.java)
}