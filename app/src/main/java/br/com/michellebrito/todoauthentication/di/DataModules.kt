package br.com.michellebrito.todoauthentication.di

import br.com.michellebrito.data.repository.AuthRepositoryImpl
import br.com.michellebrito.domain.repository.AuthRepository
import org.koin.dsl.module

object DataModules {
    val dataModuleItems = module {
        factory<AuthRepository> { AuthRepositoryImpl() }
    }
}