package com.pandulapeter.myTodos.domain

import com.pandulapeter.myTodos.domain.utilities.resultOf
import com.pandulapeter.myTodos.repository.IssueRepository

class GetIssuesUseCase(
    private val issueRepository: IssueRepository
) {
    suspend operator fun invoke() = resultOf { issueRepository.getIssues() }
}