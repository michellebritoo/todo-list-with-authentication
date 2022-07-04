package br.com.michellebrito.todoauthentication

import android.app.Application
import br.com.michellebrito.todoauthentication.di.AppModules.viewModelsModule
import br.com.michellebrito.todoauthentication.di.DataModules.dataModuleItems
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class ToDoApplication :Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@ToDoApplication)
            modules(
                listOf(
                    viewModelsModule,
                    dataModuleItems
                )
            )
        }
    }
}