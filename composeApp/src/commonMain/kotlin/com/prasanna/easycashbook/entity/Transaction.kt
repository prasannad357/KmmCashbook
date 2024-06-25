package com.prasanna.easycashbook.entity





data class Transaction(
    //LocalDate.now() to get the date in yyyy-mm-dd format,
    // Use LocalDate.now().compareTo(LocalDate.parse("2023-10-07")) to compare
    val id:Int? = null,
    val date:String,
    val amount:Double,
    val isCredit:Boolean,
    val createdAt:Long, //System.currentTimeMillis() i.e. epoch time, can be easily compared
    val updatedAt:Long, //System.currentTimeMillis() i.e. epoch time, can be easily compared
    val cashbookId:Int,
    val cashbookName:String,
    val tags: List<String> = emptyList(),
    val remark:String = "",
    val inBin:Boolean = false
)
