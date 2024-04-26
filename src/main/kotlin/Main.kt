import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.ui.window.Window
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.res.loadImageBitmap
import androidx.compose.ui.res.useResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.application


fun main() = application {
    val icon = BitmapPainter(useResource("linux-tux-logo-8C1B4FB97E-seeklogo.com.png", ::loadImageBitmap))

    Window(
        onCloseRequest = ::exitApplication,
        title = "Ejercicio Ventanas",
        icon = icon
    ) {
        var showMainWindow by remember { mutableStateOf(true) }

        if (showMainWindow) {
            MainWindow(openSecondWindow = { showMainWindow = false })
        } else {
            SecondWindow(openMainWindow = { showMainWindow = true })
        }
    }
}

@Composable
@Preview
fun MainWindow(openSecondWindow: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Main Window")
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = openSecondWindow) {
            Text("Abrir Second Window")
        }
    }
}

@Composable
@Preview
fun SecondWindow(openMainWindow: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Second Window")
        Spacer(modifier = Modifier.height(100.dp))
        Button(onClick = openMainWindow) {
            Text("Abrir Main Window")
        }
    }
}