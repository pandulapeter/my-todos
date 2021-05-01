import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import com.pandulapeter.myTodos.presentation.resources.Color
import com.pandulapeter.myTodos.presentation.ui.DemoPicker

@Composable
fun MyTodosApp() = MaterialTheme(
    colors = lightColors(
        primary = Color.brand,
        primaryVariant = Color.brand,
        secondary = Color.brand,
        secondaryVariant = Color.brand
    ),
    content = { DemoPicker() }
)