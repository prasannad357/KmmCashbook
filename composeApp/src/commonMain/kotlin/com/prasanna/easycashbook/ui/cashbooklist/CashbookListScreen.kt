package com.prasanna.easycashbook.ui.cashbooklist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import com.prasanna.easycashbook.ui.addcashbook.AddCashbookScreen
import com.prasanna.easycashbook.ui.theme.primaryBg
import com.prasanna.easycashbook.ui.theme.secondaryBg
import org.koin.compose.koinInject

class CashbookListScreen: Screen {
    @Composable
    override fun Content() {
        println("cashbooks: CashbookListScreen().content() called")
        val navigator = LocalNavigator.current
        val viewModel = navigator?.koinNavigatorScreenModel<CashbookListViewModel>()
        viewModel?.let{
            it.updateData()
            CashbookListScreen(it, navigator)
        }
    }

    @Composable
    fun CashbookListScreen(viewModel: CashbookListViewModel, navigator: Navigator){
        Scaffold(
            modifier = Modifier,
            topBar = {Text("Cashbooks")},
            floatingActionButton = {
                FloatingActionButton(
                    onClick = {
                        navigator.push(AddCashbookScreen())
                    },
                ){
                    Icon(imageVector = Icons.Default.Add, contentDescription = "Add Cashbook")
                }
            }
        ){scaffoldPadding ->
            LazyColumn(modifier = Modifier.padding(scaffoldPadding).padding(start = 12.dp, end=12.dp)) {
                println("cashbooks: ${viewModel.cashbooks.value}")
                items(viewModel.cashbooks.value){ cashbook ->
                    CashbookListItem(cashbook)
                    Spacer(modifier = Modifier.height(12.dp))
                }
            }
        }
    }

}
