import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.prasanna.easycashbook.di.initKoin
import com.prasanna.easycashbook.local.Cashbook
import org.jetbrains.compose.resources.painterResource
import org.jetbrains.compose.ui.tooling.preview.Preview

import easycashbook.composeapp.generated.resources.Res
import easycashbook.composeapp.generated.resources.compose_multiplatform
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.koinInject
import org.koin.core.KoinApplication
import org.koin.core.context.startKoin

@Composable
fun App() {

    MaterialTheme {

        KoinContext {
            Cashbooks()
        }

    }
}

@Composable
fun Cashbooks(sdk:CashbookSDK = koinInject()){
    val tag = "cblogs"
    var cashbooks = remember { mutableStateListOf<Cashbook>() }
    println("$tag: Cashbooks before being fetched $cashbooks")
    LaunchedEffect(Unit){
        println("$tag: Fetching cashbooks")
        cashbooks.addAll(
            sdk.getCashbooks()
        )
        println("$tag: Fetched cashbooks: ${cashbooks}")
    }
    val scope = rememberCoroutineScope()
    LazyColumn {
        println("$tag: Printing all cashbooks")
        items(cashbooks){cashbook ->
            println("$tag: cashbook: ${cashbook.name}")
            Row {
                Text(cashbook.name)
            }
        }

        item { Button(onClick = {
            scope.launch {
                sdk.createCashbook(Cashbook(
                    name = "Second cashbook",
                    tags = emptyList(),
                    createdDate = "",
                    createdTimeStamp = "",
                    lastEditTimeStamp = "",
                    id = 1.toLong()
                ))
            }


        }){
            Text("Add Cashbook")
        } }
    }
}