package com.prasanna.easycashbook.local

import app.cash.sqldelight.ColumnAdapter

class TagsConverter():ColumnAdapter<List<String>, String>{
    override fun decode(databaseValue: String): List<String> {
        return databaseValue.split("%2C")
    }

    override fun encode(value: List<String>): String {
        return value.joinToString("%2C")
    }

}