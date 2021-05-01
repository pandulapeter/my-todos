package com.pandulapeter.myTodos.sourceRemoteImpl

import io.ktor.client.HttpClient
import io.ktor.client.engine.java.Java

actual fun createHttpClient() = HttpClient(Java)