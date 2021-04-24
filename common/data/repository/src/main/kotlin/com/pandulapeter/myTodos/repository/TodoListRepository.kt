package com.pandulapeter.myTodos.repository

import com.pandulapeter.myTodos.model.TodoList

interface TodoListRepository {

    fun getTodoList(): TodoList
}