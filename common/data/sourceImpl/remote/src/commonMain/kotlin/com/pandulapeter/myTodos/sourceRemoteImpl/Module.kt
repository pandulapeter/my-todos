package com.pandulapeter.myTodos.sourceRemoteImpl

import com.pandulapeter.myTodos.sourceRemote.TodoListRemoteSource
import org.koin.dsl.module

val remoteSourceModule = module {
    factory<TodoListRemoteSource> { TodoListRemoteSourceImpl() }
}