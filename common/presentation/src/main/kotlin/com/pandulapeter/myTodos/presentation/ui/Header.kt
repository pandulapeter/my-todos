package com.pandulapeter.myTodos.presentation.ui

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.pandulapeter.myTodos.presentation.model.Demo
import com.pandulapeter.myTodos.presentation.resources.Color
import com.pandulapeter.myTodos.presentation.resources.Dimension
import com.pandulapeter.myTodos.presentation.resources.Text

@Composable
internal fun Header(
    demos: List<Demo>,
    selectedDemo: Demo,
    onSelectionChanged: (Demo) -> Unit
) {
    Title()
    TabLayout(
        demos = demos,
        selectedDemo = selectedDemo,
        onSelectionChanged = onSelectionChanged
    )
}

@Composable
private fun Title() = Text(
    text = Text.myTodos,
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = Dimension.contentPaddingExtraLarge),
    style = MaterialTheme.typography.h2.copy(color = Color.brand),
    textAlign = TextAlign.Center
)

@Composable
private fun TabLayout(
    demos: List<Demo>,
    selectedDemo: Demo,
    onSelectionChanged: (Demo) -> Unit
) = TabRow(
    modifier = Modifier
        .fillMaxWidth()
        .padding(top = Dimension.contentPaddingExtraLarge),
    tabs = {
        demos.forEach { demo ->
            Tab(
                selected = selectedDemo == demo,
                onClick = { onSelectionChanged(demo) },
                content = {
                    Text(
                        text = demo.title,
                        modifier = Modifier.padding(Dimension.contentPadding)
                    )
                }
            )
        }
    },
    selectedTabIndex = demos.indexOf(selectedDemo)
)