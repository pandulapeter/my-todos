package com.pandulapeter.myTodos.repository

import org.koin.dsl.module

val repositoryModule = module {
    single<TodoListRepository> { TodoListRepositoryImpl(get(), get()) }
    single<IssueRepository> { IssueRepositoryImpl(get()) }
}