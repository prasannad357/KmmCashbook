package com.prasanna.easycashbook.ui.addcashbook

data class AddCashbookState(
    val name:String = "",
    val tags: List<String> = emptyList(),
    val createdDate:String,
    val createdTimeStamp:String,
    val lastEditTimeStamp:String,
    val id:Int? = null
)
