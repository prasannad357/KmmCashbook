package com.prasanna.easycashbook.ui.addcashbook

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
import kotlinx.coroutines.launch
import kotlinx.datetime.Clock
import kotlinx.datetime.TimeZone
import kotlinx.datetime.todayIn

class AddCashbookViewModel(private val sdk: CashbookSDK):ScreenModel {

    private var addCbJob: Job? = null

    private val timeStamp = Clock.System.now().toEpochMilliseconds().toString()
    private var _cashbook:MutableState<Cashbook> = mutableStateOf(Cashbook(
        name = "",
        tags = emptyList(),
        createdDate = Clock.System.todayIn(TimeZone.currentSystemDefault()).toString(),
        createdTimeStamp = timeStamp,
        lastEditTimeStamp = timeStamp,
        id = 0,
    ))

    val cashbook: State<Cashbook> = _cashbook

    fun onEvent(event:AddCashbookEvent){
        when(event){
            is AddCashbookEvent.AddCashbook -> addCashbook()
            is AddCashbookEvent.AddCashbookName -> _cashbook.value = _cashbook.value.copy(name = event.name)
            is AddCashbookEvent.AddCashbookTags -> _cashbook.value = _cashbook.value.copy(tags = event.tags)
        }
    }
    fun addCashbook(){
        addCbJob?.cancel()
        addCbJob = screenModelScope.launch {
            sdk.createCashbook(_cashbook.value)
        }
    }
}