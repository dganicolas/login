import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
fun MainScreen() {
    val studentsState = remember { mutableStateListOf("Esther", "Jaime") }
    Surface(
        color = Color.LightGray,
        modifier = Modifier.fillMaxSize()
    ) {
        StudentList(studentsState) {
            studentsState.add("Miguel")
        }
    }
}
@Composable
fun StudentText(name: String) {
    Text(
        text = name,
        style = MaterialTheme.typography.h5,
        modifier = Modifier.padding(10.dp)
    )
}

@Composable
fun StudentList(students: List<String>, onButtonClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        for(student in students) {
            StudentText(name = student)
        }
        Button(
            onClick = onButtonClick,
        ) {
            Text(text = "Add new student")
        }
    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
        title = "mi login") {
        MainScreen()
    }
}