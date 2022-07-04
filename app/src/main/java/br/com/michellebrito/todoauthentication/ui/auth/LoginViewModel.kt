package br.com.michellebrito.todoauthentication.ui.auth

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.michellebrito.domain.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult

class LoginViewModel(private val repository: AuthRepository) : ViewModel() {
    val loginSuccess: LiveData<Boolean> get() = _loginSuccess
    private val _loginSuccess = MutableLiveData<Boolean>()

    fun login(email: String, password: String) {
        val result = repository.login(email, password) as Task<AuthResult>
        result.let {
            it.addOnSuccessListener { _loginSuccess.value = true }
            it.addOnFailureListener { _loginSuccess.value = false }
        }
    }
}