import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.MaterialTheme
import androidx.compose.material.RadioButton
import androidx.compose.material.Tab
import androidx.compose.material.TabRow
import androidx.compose.material.Text
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.pandulapeter.myTodos.domain.GetTodoListUseCase
import com.pandulapeter.myTodos.model.TodoList
import com.pandulapeter.myTodos.presentation.resources.Color
import com.pandulapeter.myTodos.presentation.resources.Dimension
import com.pandulapeter.myTodos.presentation.resources.Text
import com.pandulapeter.myTodos.presentation.utilities.get

@Composable
fun MyTodosApp(
    getTodoList: GetTodoListUseCase = get()
) {
    var shouldUseRemoteSource by remember { mutableStateOf(false) }
    var selectedDemo by remember { mutableStateOf(Demo.DEMO_1) }

    MaterialTheme(
        colors = lightColors(
            primary = Color.brand,
            primaryVariant = Color.brand,
            secondary = Color.brand,
            secondaryVariant = Color.brand
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight()
                .padding(
                    start = Dimension.sidePadding,
                    end = Dimension.sidePadding
                )
        ) {
            Title()
            TabLayout(
                demos = Demo.values().toList(),
                selectedDemo = selectedDemo,
                onSelectionChanged = { selectedDemo = it }
            )
            when (selectedDemo) {
                Demo.DEMO_1 -> {
                    SourceSelector(
                        shouldUseRemoteSource = shouldUseRemoteSource,
                        onShouldUseRemoteSourceChanged = { shouldUseRemoteSource = it }
                    )
                    Content(
                        todoList = getTodoList(shouldUseRemoteSource)
                    )
                }
                Demo.DEMO_2 -> {
                    Text(
                        text = "Work in progress",
                        modifier = Modifier
                            .padding(Dimension.contentPadding)
                            .padding(top = Dimension.contentPaddingExtraLarge)
                            .align(Alignment.CenterHorizontally)
                    )
                }
            }
        }
    }
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

private enum class Demo(val title: String) {
    DEMO_1(Text.demo1),
    DEMO_2(Text.demo2)
}

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