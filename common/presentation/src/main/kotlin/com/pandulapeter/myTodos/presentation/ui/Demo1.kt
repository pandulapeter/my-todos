package com.pandulapeter.myTodos.presentation.ui

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CornerSize
import androidx.compose.foundation.shape.RoundedCornerShape
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
import androidx.compose.ui.draw.clip
import androidx.compose.ui.text.style.TextAlign
import com.pandulapeter.myTodos.domain.GetTodoListUseCase
import com.pandulapeter.myTodos.model.TodoList
import com.pandulapeter.myTodos.presentation.resources.Dimension
import com.pandulapeter.myTodos.presentation.resources.Text
import com.pandulapeter.myTodos.presentation.utilities.get

@Composable
internal fun Demo1(
    getTodoList: GetTodoListUseCase = get(),
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
private fun SourceSelector(
    shouldUseRemoteSource: Boolean,
    onShouldUseRemoteSourceChanged: (Boolean) -> Unit,
) = Row(
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = Dimension.contentPaddingExtraLarge),
    horizontalArrangement = Arrangement.Center,
    verticalAlignment = Alignment.CenterVertically
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
private fun LabeledRadioButton(
    text: String,
    value: Boolean,
    onValueChanged: () -> Unit,
) {
    Row(
        modifier = Modifier
            .clip(RoundedCornerShape(corner = CornerSize(Dimension.contentPaddingLarge)))
            .clickable(onClick = onValueChanged)
            .padding(Dimension.contentPadding),
    ) {
        RadioButton(
            modifier = Modifier.align(Alignment.CenterVertically),
            selected = value,
            onClick = null
        )
        Spacer(modifier = Modifier.size(Dimension.contentPadding))
        Text(
            modifier = Modifier
                .padding(all = Dimension.contentPadding)
                .align(Alignment.CenterVertically),
            text = text
        )
    }
}

@Composable
private fun Content(todoList: TodoList) {
    Text(
        text = todoList.content,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = Dimension.contentPaddingLarge),
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.body2
    )
}