package com.prasanna.easycashbook.ui.cashbooklist

import CashbookSDK
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import com.prasanna.easycashbook.local.Cashbook
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class CashbookListViewModel(private val sdk:CashbookSDK): ScreenModel {
    private val _cashbooks: MutableState<List<Cashbook>> = mutableStateOf<List<Cashbook>>(emptyList())
    val cashbooks: State<List<Cashbook>> = _cashbooks

    var _job:Job? = null

    fun updateData(){
        getCashbooks()
    }

    private fun getCashbooks(){
        _job?.cancel()
        _job = screenModelScope.launch {
            _cashbooks.value = sdk.getCashbooks()
        }
    }



}