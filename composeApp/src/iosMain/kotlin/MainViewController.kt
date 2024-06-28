import androidx.compose.ui.window.ComposeUIViewController
import com.prasanna.easycashbook.di.initKoin
import com.prasanna.easycashbook.ui.App

fun MainViewController() = ComposeUIViewController {

    initKoin {}
    App() }