package com.pandulapeter.myTodos.domain

import com.pandulapeter.myTodos.repository.TodoListRepository

class GetTodoListUseCase(
    private val todoListRepository: TodoListRepository
) {
    operator fun invoke(shouldUseRemoteSource: Boolean) = todoListRepository.getTodoList(shouldUseRemoteSource)
}