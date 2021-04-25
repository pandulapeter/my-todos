package com.pandulapeter.myTodos

import MyTodosApp
import androidx.compose.desktop.Window
import com.pandulapeter.myTodos.domain.domainModule
import com.pandulapeter.myTodos.presentation.resources.Text
import com.pandulapeter.myTodos.repository.repositoryModule
import com.pandulapeter.myTodos.sourceLocalImpl.localSourceModule
import com.pandulapeter.myTodos.sourceRemoteImpl.remoteSourceModule
import org.koin.core.context.startKoin

fun main() {
    startKoin {
        modules(localSourceModule + remoteSourceModule + repositoryModule + domainModule)
    }
    Window(
        title = Text.myTodos,
        resizable = false,
        content = { MyTodosApp() }
    )
}