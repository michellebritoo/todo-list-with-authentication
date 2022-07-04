package br.com.michellebrito.domain.repository

interface AuthRepository {
    fun login(email: String, password: String): Any
}