package br.com.michellebrito.todoauthentication.ui.utils

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.fragment.app.Fragment

fun Fragment.hideKeyboard() {
    val imm = context?.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow(view?.windowToken, ZERO_VALUE)
}

private const val ZERO_VALUE = 0