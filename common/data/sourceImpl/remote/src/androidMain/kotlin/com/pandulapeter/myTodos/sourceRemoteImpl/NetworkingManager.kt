package com.pandulapeter.myTodos.sourceRemoteImpl

import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp

actual fun createHttpClient() = HttpClient(OkHttp)