package br.com.michellebrito.todoauthentication.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.michellebrito.domain.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess
    val enableButton: LiveData<Boolean> get() = _enableButton
    private val _loginSuccess = MutableLiveData<Boolean>()
    private val _enableButton = MutableLiveData<Boolean>()

    private val loginForm = LoginForm()

    fun login(email: String, password: String) {
        val result = repository.login(email, password) as Task<AuthResult>
        result.let {
            it.addOnSuccessListener { _loginSuccess.value = true }
            it.addOnFailureListener { _loginSuccess.value = false }
        }
    }

    fun onEmailTextChanged(text : CharSequence?){
        loginForm.email = text.toString()
        _enableButton.value = loginForm.isValidForm()
    }

    fun onPasswordTextChanged(text : CharSequence?){
        loginForm.password = text.toString()
        _enableButton.value = loginForm.isValidForm()
    }
}