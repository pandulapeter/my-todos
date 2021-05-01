package com.pandulapeter.myTodos.repository

import com.pandulapeter.myTodos.sourceRemote.IssueRemoteSource

internal class IssueRepositoryImpl(
    private val issueRemoteSource: IssueRemoteSource
) : IssueRepository {

    override suspend fun getIssues() = issueRemoteSource.getIssues()
}