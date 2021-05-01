package com.pandulapeter.myTodos.sourceRemoteImpl

import com.pandulapeter.myTodos.sourceRemote.IssueRemoteSource

internal class IssueRemoteSourceImpl(
    private val networkingManager: NetworkingManager
) : IssueRemoteSource {

    override suspend fun getIssues() = networkingManager.getIssues()
}