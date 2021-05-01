package com.pandulapeter.myTodos.presentation.ui

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pandulapeter.myTodos.domain.GetIssuesUseCase
import com.pandulapeter.myTodos.domain.utilities.ResultWrapper
import com.pandulapeter.myTodos.model.Issue
import com.pandulapeter.myTodos.presentation.resources.Dimension
import com.pandulapeter.myTodos.presentation.resources.Text
import com.pandulapeter.myTodos.presentation.utilities.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

@Composable
internal fun ColumnScope.Demo2(
    getIssues: GetIssuesUseCase = get()
) {
    var issues by remember { mutableStateOf<ResultWrapper<List<Issue>>?>(null) }

    fun loadIssues() {
        issues = null
        GlobalScope.launch {
            val newIssues = getIssues()
            launch(Dispatchers.Main) {
                issues = newIssues
            }
        }
    }

    when (val currentIssues = issues) {
        null -> {
            LoadingIndicator()
            loadIssues()
        }
        is ResultWrapper.Error -> {
            ErrorState(
                onTryAgainButtonPressed = ::loadIssues
            )
        }
        is ResultWrapper.Success -> {
            IdleState(
                issues = currentIssues.data
            )
        }
    }
}

@Composable
private fun ColumnScope.LoadingIndicator() = CircularProgressIndicator(
    modifier = Modifier
        .padding(top = Dimension.contentPaddingExtraLarge)
        .align(Alignment.CenterHorizontally)
)

@Composable
private fun ColumnScope.ErrorState(
    onTryAgainButtonPressed: () -> Unit
) {
    Text(
        text = Text.somethingWentWrong,
        modifier = Modifier
            .padding(top = Dimension.contentPaddingExtraLarge)
            .align(Alignment.CenterHorizontally)
    )
    Button(
        content = {
            Text(
                text = Text.tryAgain
            )
        },
        modifier = Modifier
            .padding(top = Dimension.contentPaddingExtraLarge)
            .align(Alignment.CenterHorizontally),
        onClick = onTryAgainButtonPressed
    )
}

@Composable
private fun ColumnScope.IdleState(
    issues: List<Issue>
) = Text(
    text = if (issues.isEmpty()) Text.issuesEmpty else "${issues.size}${Text.issuesIdle}",
    modifier = Modifier
        .padding(top = Dimension.contentPaddingExtraLarge)
        .align(Alignment.CenterHorizontally)
)