package br.com.michellebrito.todoauthentication.ui.auth

import android.util.Patterns

class LoginForm {
    var email: String = EMPTY_TEXT
    var password: String = EMPTY_TEXT
    private val pattern = Patterns.EMAIL_ADDRESS

    fun isValidForm(): Boolean = isValidEmail() && password.isNotBlank()

    private fun isValidEmail() : Boolean = email.isNotBlank() && pattern.matcher(email).matches()

    private companion object {
        const val EMPTY_TEXT = ""
    }
}