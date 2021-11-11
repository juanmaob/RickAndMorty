package com.seventhson.rickandmorty.ui.common

import android.app.Dialog
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.viewbinding.ViewBinding
import com.google.android.material.snackbar.Snackbar
import com.seventhson.rickandmorty.data.sharedPreferences.SharedPrefs
import com.seventhson.rickandmorty.utils.DialogUtil
import com.seventhson.rickandmorty.utils.Navigator
import com.seventhson.rickandmorty.utils.ViewModelFactory
import com.seventhson.rickandmorty.utils.showCustomMessage
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class BaseActivity<V: ViewBinding>: AppCompatActivity() {

    @Inject
    lateinit var navigator: Navigator

    @Inject
    lateinit var sharedPrefs: SharedPrefs

    open val progressDialog: Dialog by lazy { DialogUtil().getLoadingDialog(this) }

    lateinit var binding: V

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        binding = getViewBinding()
        setContentView(binding.root)
    }

    abstract fun getViewBinding(): V

    inline fun <reified T : ViewModel> ViewModelFactory<T>.get(): T =
        ViewModelProvider(this@BaseActivity, this).get(T::class.java)

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

    fun handleError(it: Map<Int, String>) {
        showCustomMessage(it.values.first(), Snackbar.LENGTH_LONG)
        when (it.keys.first()) {
            401 -> logout()
        }
    }

    fun logout() {

    }
}