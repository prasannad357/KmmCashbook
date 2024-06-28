package com.prasanna.easycashbook.ui

import CashbookSDK
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import cafe.adriel.voyager.navigator.Navigator
import com.prasanna.easycashbook.local.Cashbook
import com.prasanna.easycashbook.ui.cashbooklist.CashbookListScreen
import com.prasanna.easycashbook.ui.cashbooklist.CashbookListViewModel

import kotlinx.coroutines.launch
import org.koin.compose.KoinContext
import org.koin.compose.koinInject

@Composable
fun App() {

    MaterialTheme {

        KoinContext {
            Navigator(CashbookListScreen())
        }

    }
}

