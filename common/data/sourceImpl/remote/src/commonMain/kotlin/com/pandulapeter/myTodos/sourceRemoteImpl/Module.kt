package com.pandulapeter.myTodos.sourceRemoteImpl

import com.pandulapeter.myTodos.sourceRemote.IssueRemoteSource
import com.pandulapeter.myTodos.sourceRemote.TodoListRemoteSource
import org.koin.dsl.module

val remoteSourceModule = module {
    single { NetworkingManager() }
    factory<TodoListRemoteSource> { TodoListRemoteSourceImpl(get()) }
    factory<IssueRemoteSource> { IssueRemoteSourceImpl(get()) }
}