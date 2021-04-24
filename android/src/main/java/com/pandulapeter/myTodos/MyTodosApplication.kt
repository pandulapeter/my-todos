package com.pandulapeter.myTodos

import android.app.Application
import com.pandulapeter.myTodos.domain.domainModule
import com.pandulapeter.myTodos.repository.repositoryModule
import com.pandulapeter.myTodos.sourceLocalImpl.localSourceModule
import com.pandulapeter.myTodos.sourceRemoteImpl.remoteSourceModule
import org.koin.core.context.startKoin

@Suppress("unused")
class MyTodosApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            modules(
                localSourceModule + remoteSourceModule + repositoryModule + domainModule
            )
        }
    }
}