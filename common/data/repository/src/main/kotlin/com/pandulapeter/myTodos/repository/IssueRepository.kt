package com.pandulapeter.myTodos.repository

import com.pandulapeter.myTodos.model.Issue
import com.pandulapeter.myTodos.model.TodoList

interface IssueRepository {

    suspend fun getIssues() : List<Issue>
}