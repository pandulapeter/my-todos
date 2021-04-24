import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.pandulapeter.myTodos.domain.GetTodoListUseCase
import com.pandulapeter.myTodos.presentation.utilities.get

@Composable
fun MyTodosApp(
    getTodoList: GetTodoListUseCase = get()
) {
    var text by remember { mutableStateOf("Hello, World!") }

    MaterialTheme(
        content = {
            Button(
                onClick = { text = "Hello! ${getTodoList().content}" },
                content = { Text(text) }
            )
        }
    )
}