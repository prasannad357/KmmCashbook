import androidx.compose.ui.window.ComposeUIViewController
import com.prasanna.easycashbook.di.initKoin

fun MainViewController() = ComposeUIViewController {

    initKoin {}
    App() }