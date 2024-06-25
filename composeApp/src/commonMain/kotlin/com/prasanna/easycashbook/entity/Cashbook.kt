package com.prasanna.easycashbook.entity

data class Cashbook(
    val name:String,
    val tags: List<String>,
    val createdDate:String,
    val createdTimeStamp:String,
    val lastEditTimeStamp:String,
    val id:Int? = null
)
