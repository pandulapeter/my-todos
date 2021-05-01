package com.pandulapeter.myTodos.sourceRemoteImpl

import com.pandulapeter.myTodos.model.TodoList
import com.pandulapeter.myTodos.sourceRemote.TodoListRemoteSource

internal class TodoListRemoteSourceImpl(
    private val networkingManager: NetworkingManager
) : TodoListRemoteSource {

    override fun getTodoList() = object : TodoList {

        override val content = "${getPlatformName()} (${networkingManager.verify()})"
    }
}

internal expect fun getPlatformName(): String