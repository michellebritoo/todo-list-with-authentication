package br.com.michellebrito.todoauthentication.di

import br.com.michellebrito.todoauthentication.ui.auth.LoginViewModel
import br.com.michellebrito.todoauthentication.ui.taskList.TaskListViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {
    val viewModelsModule = module {
        viewModel { LoginViewModel(repository = get()) }
        viewModel { TaskListViewModel() }
    }
}