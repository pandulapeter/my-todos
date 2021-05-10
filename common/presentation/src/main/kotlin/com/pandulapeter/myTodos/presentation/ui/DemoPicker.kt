package com.pandulapeter.myTodos.presentation.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import com.pandulapeter.myTodos.presentation.model.Demo
import com.pandulapeter.myTodos.presentation.resources.Dimension

@Composable
internal fun DemoPicker() {

    var selectedDemo by remember { mutableStateOf(Demo.values().first()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = Dimension.sidePadding),
        content = {
            Header(
                demos = Demo.values().toList(),
                selectedDemo = selectedDemo,
                onSelectionChanged = { selectedDemo = it }
            )
            when (selectedDemo) {
                Demo.DEMO_1 -> Demo1()
                Demo.DEMO_2 -> Demo2()
            }
        }
    )
}