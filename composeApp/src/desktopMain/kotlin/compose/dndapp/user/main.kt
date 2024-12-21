package compose.dndapp.user

import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import compose.dndapp.user.ui.view.MainView

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DnDAppMP",
    ) {
        MainView()
    }
}