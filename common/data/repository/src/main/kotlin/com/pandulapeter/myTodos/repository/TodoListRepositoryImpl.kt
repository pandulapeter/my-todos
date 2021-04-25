package com.pandulapeter.myTodos.repository

import com.pandulapeter.myTodos.sourceLocal.TodoListLocalSource
import com.pandulapeter.myTodos.sourceRemote.TodoListRemoteSource

internal class TodoListRepositoryImpl(
    private val todoListLocalSource: TodoListLocalSource,
    private val todoListRemoteSource: TodoListRemoteSource
) : TodoListRepository {

    override fun getTodoList(shouldUseRemoteSource: Boolean) = if (shouldUseRemoteSource) {
        todoListRemoteSource.getTodoList()
    } else {
        todoListLocalSource.getTodoList()
    }
}