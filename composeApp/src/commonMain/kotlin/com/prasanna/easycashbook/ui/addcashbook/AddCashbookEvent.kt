package com.prasanna.easycashbook.ui.addcashbook

import com.prasanna.easycashbook.local.Cashbook

sealed class AddCashbookEvent {
    object AddCashbook:AddCashbookEvent()
    data class AddCashbookName(val name:String):AddCashbookEvent()

    data class AddCashbookTags(val tags:List<String>):AddCashbookEvent()
}