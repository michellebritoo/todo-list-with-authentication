package br.com.michellebrito.data.repository

import br.com.michellebrito.domain.repository.AuthRepository
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class AuthRepositoryImpl : AuthRepository {
    private val firebaseAuth = Firebase.auth

    override fun login(email: String, password: String): Task<AuthResult> {
        return firebaseAuth.signInWithEmailAndPassword(email, password)
    }
}