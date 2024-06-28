package com.prasanna.easycashbook.ui.addcashbook

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.koinNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.Navigator
import com.prasanna.easycashbook.ui.cashbooklist.CashbookListScreen
import com.prasanna.easycashbook.ui.theme.primaryBg
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.koinInject

class AddCashbookScreen:Screen{
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.current
        val addCashbookViewModel = navigator?.koinNavigatorScreenModel<AddCashbookViewModel>()
        if (addCashbookViewModel != null) {
            AddCashbookScreen(addCashbookViewModel, navigator)
        }
    }
    @Composable
    fun AddCashbookScreen(viewModel: AddCashbookViewModel, navigator: Navigator){
        var name by remember {
            mutableStateOf("")
        }

        var tagsString by remember {
            mutableStateOf("")
        }

        LazyColumn(modifier = Modifier.fillMaxSize().padding(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            item {
                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = name,
                    onValueChange = {
                        name = it
                    },
                    label = {
                        Text("Enter cashbook name")
                    }
                )

                OutlinedTextField(
                    modifier = Modifier.fillMaxWidth(),
                    value = tagsString,
                    onValueChange = {
                        tagsString = it
                    },
                    label = {
                        Text("Enter tags (use comma to separate)")
                    }
                )
                Button(
                    onClick = {
                        viewModel.onEvent(AddCashbookEvent.AddCashbookName(name = name))
                        viewModel.onEvent(
                            AddCashbookEvent.AddCashbookTags(tags = tagsString.split(","))
                        )
                        viewModel.onEvent(AddCashbookEvent.AddCashbook)
                        navigator.pop()
                    }
                ){
                    Text("Add Cashbook")
                }
            }
        }
    }
}


