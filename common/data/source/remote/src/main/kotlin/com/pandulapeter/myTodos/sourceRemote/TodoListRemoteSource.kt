package com.pandulapeter.myTodos.sourceRemote

import  com.pandulapeter.myTodos.model.TodoList

interface TodoListRemoteSource {
    fun getTodoList(): TodoList
}