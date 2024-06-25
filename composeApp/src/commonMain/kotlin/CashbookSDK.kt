import com.prasanna.easycashbook.local.Cashbook
import com.prasanna.easycashbook.local.Database
import com.prasanna.easycashbook.local.DatabaseDriverFactory

class CashbookSDK(databaseDriverFactory: DatabaseDriverFactory) {
    private val database = Database(databaseDriverFactory)

    @Throws(Exception::class)
    suspend fun getCashbooks():List<Cashbook>{
        //TODO: Remove print
        val cashbooks = database.getAllCashbooks()
        println("Cashbooks: $cashbooks")
        return cashbooks
    }

    @Throws(Exception::class)
    suspend fun createCashbook(cb:Cashbook){
        return database.insertCashbook(cb = cb)
    }
}