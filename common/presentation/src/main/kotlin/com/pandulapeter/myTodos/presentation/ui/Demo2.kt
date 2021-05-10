package com.pandulapeter.myTodos.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
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

@Composable
internal fun Demo2(
    getIssues: GetIssuesUseCase = get(),
) {
    var issues by remember { mutableStateOf<ResultWrapper<List<Issue>>?>(null) }
    var retry by remember { mutableStateOf(Any()) }

    LaunchedEffect(getIssues, retry) {
        issues = getIssues()
    }

    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        when (val currentIssues = issues) {
            null -> LoadingIndicator()
            is ResultWrapper.Error -> ErrorState(
                onTryAgainButtonPressed = { issues = null; retry = Any() }
            )
            is ResultWrapper.Success -> IdleState(
                issues = currentIssues.data
            )
        }
    }
}

@Composable
private fun LoadingIndicator(
    modifier: Modifier = Modifier,
) = CircularProgressIndicator(
    modifier = Modifier
        .padding(top = Dimension.contentPaddingExtraLarge)
        .then(modifier)
)

@Composable
private fun ErrorState(
    onTryAgainButtonPressed: () -> Unit,
) {
    Text(
        text = Text.somethingWentWrong,
        modifier = Modifier
            .padding(top = Dimension.contentPaddingExtraLarge)
    )
    Button(
        onClick = onTryAgainButtonPressed,
        modifier = Modifier
            .padding(top = Dimension.contentPaddingExtraLarge),
    ) {
        Text(text = Text.tryAgain)
    }
}

@Composable
private fun IdleState(
    issues: List<Issue>,
) = Text(
    text = if (issues.isEmpty()) Text.issuesEmpty else "${issues.size}${Text.issuesIdle}",
    modifier = Modifier
        .padding(top = Dimension.contentPaddingExtraLarge)
)