package com.pandulapeter.myTodos.domain.utilities

sealed class ResultWrapper<T> {

    data class Success<T>(val data: T) : ResultWrapper<T>()

    data class Error<T>(val throwable: Throwable?) : ResultWrapper<T>()
}