package com.pandulapeter.myTodos.sourceRemote

import com.pandulapeter.myTodos.model.Issue

interface IssueRemoteSource {
    suspend fun getIssues(): List<Issue>
}