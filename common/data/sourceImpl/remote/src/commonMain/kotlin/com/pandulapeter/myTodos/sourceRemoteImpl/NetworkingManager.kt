package com.pandulapeter.myTodos.sourceRemoteImpl

import com.pandulapeter.myTodos.model.Issue
import io.ktor.client.HttpClient
import kotlinx.coroutines.delay

internal class NetworkingManager {

    private val client = createHttpClient()

    fun getEngineName() = client.engine::class.simpleName

    suspend fun getIssues(): List<Issue> {
        delay(1000)
        return if (listOf(true, false).random()) emptyList() else TODO()
    }
}

internal expect fun createHttpClient(): HttpClient