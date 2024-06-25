package com.prasanna.easycashbook.local

import app.cash.sqldelight.ColumnAdapter

internal class Database(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = CashbookDatabase(
        databaseDriverFactory.createDriver(),
        CashbookAdapter = Cashbook.Adapter(tagsAdapter = TagsConverter())
        )
    private val dbQuery = database.cashbookDatabaseQueries

    internal fun getAllCashbooks():List<Cashbook>{
        return dbQuery.selectAllCashbooks().executeAsList()
    }

    internal fun insertCashbook(cb: Cashbook){
        dbQuery.insertCashbook(
            name = cb.name,
            tags = cb.tags,
            createdDate = cb.createdDate,
            createdTimeStamp = cb.createdTimeStamp,
            lastEditTimeStamp = cb.lastEditTimeStamp,
            id = null
        )
    }

}