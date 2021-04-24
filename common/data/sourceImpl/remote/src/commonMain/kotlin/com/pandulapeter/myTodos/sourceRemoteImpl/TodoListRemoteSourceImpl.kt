package com.pandulapeter.myTodos.sourceRemoteImpl

import com.pandulapeter.myTodos.model.TodoList
import com.pandulapeter.myTodos.sourceRemote.TodoListRemoteSource

internal class TodoListRemoteSourceImpl : TodoListRemoteSource {

    override fun getTodoList() = object : TodoList {

        override val content = getPlatformName()
    }
}

internal expect fun getPlatformName(): String