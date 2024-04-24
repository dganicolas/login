import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application

@Composable
@Preview
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    var usuario by remember { mutableStateOf("") }
    var contrasena by remember { mutableStateOf("") }
    var visibilidad by remember { mutableStateOf(false) }
    MaterialTheme {
        Column (
            modifier = Modifier.fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            OutlinedTextField(
                value = usuario,
                onValueChange = {usuario = it},
                label = { Text("Usuario")}
            )
            OutlinedTextField(
                value = contrasena,
                onValueChange = {contrasena = it},
                label = { Text("Contraseña")},
                visualTransformation =  if(visibilidad) VisualTransformation.None  else PasswordVisualTransformation('d'),
                trailingIcon = {
                    IconToggleButton(
                        checked = visibilidad,
                        onCheckedChange = {visibilidad = it}
                    ) {
                        Icon(
                            imageVector = if(!visibilidad){Icons.Default.VisibilityOff}else{Icons.Default.Visibility},
                            contentDescription = "Clear"
                        )
                    }
                }
            )
            Button(onClick = {
                usuario = ""
                contrasena = ""
            },
                enabled = usuario.isNotBlank() && contrasena.isNotBlank()


            ) {
                Text ("Login")
            }
        }

    }
}

fun main() = application {
    Window(onCloseRequest = ::exitApplication,
           title = "mi login") {
        App()
    }
}
