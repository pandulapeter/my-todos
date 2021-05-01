package com.pandulapeter.myTodos.domain.utilities

internal suspend inline fun <reified T> resultOf(crossinline action: suspend () -> T): ResultWrapper<T> = try {
    ResultWrapper.Success(action())
} catch (exception: Throwable) {
    ResultWrapper.Error(exception)
}