package com.pandulapeter.myTodos.domain

import org.koin.dsl.module

val domainModule = module {
    factory { GetTodoListUseCase(get()) }
    factory { GetIssuesUseCase(get()) }
}