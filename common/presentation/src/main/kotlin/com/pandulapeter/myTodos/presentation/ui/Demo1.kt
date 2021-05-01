package com.pandulapeter.myTodos.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.pandulapeter.myTodos.domain.GetTodoListUseCase
import com.pandulapeter.myTodos.model.TodoList
import com.pandulapeter.myTodos.presentation.resources.Dimension
import com.pandulapeter.myTodos.presentation.resources.Text
import com.pandulapeter.myTodos.presentation.utilities.get

@Composable
internal fun ColumnScope.Demo1(
    getTodoList: GetTodoListUseCase = get()
) {
    var shouldUseRemoteSource by remember { mutableStateOf(false) }

    SourceSelector(
        shouldUseRemoteSource = shouldUseRemoteSource,
        onShouldUseRemoteSourceChanged = { shouldUseRemoteSource = it }
    )
    Content(
        todoList = getTodoList(shouldUseRemoteSource)
    )
}

@Composable
private fun ColumnScope.SourceSelector(
    shouldUseRemoteSource: Boolean,
    onShouldUseRemoteSourceChanged: (Boolean) -> Unit
) = Row(
    modifier = Modifier
        .align(Alignment.CenterHorizontally)
        .padding(top = Dimension.contentPaddingExtraLarge),
) {
    LabeledRadioButton(
        text = Text.localSource,
        value = !shouldUseRemoteSource,
        onValueChanged = { onShouldUseRemoteSourceChanged(false) }
    )
    Spacer(modifier = Modifier.size(Dimension.contentPaddingLarge))
    LabeledRadioButton(
        text = Text.remoteSource,
        value = shouldUseRemoteSource,
        onValueChanged = { onShouldUseRemoteSourceChanged(true) }
    )
}

@Composable
private fun RowScope.LabeledRadioButton(
    text: String,
    value: Boolean,
    onValueChanged: () -> Unit
) {
    RadioButton(
        modifier = Modifier.align(Alignment.CenterVertically),
        selected = value,
        onClick = onValueChanged,
    )
    Spacer(modifier = Modifier.size(Dimension.contentPadding))
    Text(
        modifier = Modifier
            .clickable(onClick = onValueChanged)
            .padding(all = Dimension.contentPadding)
            .align(Alignment.CenterVertically),
        text = text
    )
}

@Composable
private fun ColumnScope.Content(todoList: TodoList) {
    Text(
        text = todoList.content,
        modifier = Modifier
            .align(Alignment.CenterHorizontally)
            .padding(top = Dimension.contentPaddingLarge),
        style = MaterialTheme.typography.body2
    )
}