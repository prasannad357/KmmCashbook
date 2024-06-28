import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.prasanna.easycashbook.di.initKoin
import com.prasanna.easycashbook.ui.App

fun main() = application {
    initKoin{}
    Window(
        onCloseRequest = ::exitApplication,
        title = "EasyCashbook",
    ) {
        App()
    }
}