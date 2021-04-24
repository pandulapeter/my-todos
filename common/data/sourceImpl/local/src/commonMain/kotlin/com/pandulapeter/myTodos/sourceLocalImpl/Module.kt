package com.pandulapeter.myTodos.sourceLocalImpl

import com.pandulapeter.myTodos.sourceLocal.TodoListLocalSource
import org.koin.dsl.module

val localSourceModule = module {
    factory<TodoListLocalSource> { TodoListLocalSourceImpl() }
}