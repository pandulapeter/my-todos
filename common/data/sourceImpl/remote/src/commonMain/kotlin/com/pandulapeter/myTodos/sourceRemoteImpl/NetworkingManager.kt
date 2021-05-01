package com.pandulapeter.myTodos.sourceRemoteImpl

import io.ktor.client.HttpClient

internal class NetworkingManager {

    private val client = createHttpClient()

    fun verify() = client.engine::class.simpleName
}

internal expect fun createHttpClient() : HttpClient