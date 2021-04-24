package com.pandulapeter.myTodos.sourceLocalImpl

import com.pandulapeter.myTodos.model.TodoList
import com.pandulapeter.myTodos.sourceLocal.TodoListLocalSource

internal class TodoListLocalSourceImpl : TodoListLocalSource {

    override fun getTodoList() = object : TodoList {
        override val content = getPlatformName()
    }
}

internal expect fun getPlatformName(): String