package com.pandulapeter.myTodos.sourceLocal

import  com.pandulapeter.myTodos.model.TodoList

interface TodoListLocalSource {
    fun getTodoList(): TodoList
}