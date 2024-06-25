package com.prasanna.easycashbook

import android.app.Application
import com.prasanna.easycashbook.di.initKoin
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class CashbookApp: Application() {
    override fun onCreate() {
        super.onCreate()

        initKoin {
            androidLogger(if (isDebug) Level.ERROR else Level.NONE)
            androidContext(this@CashbookApp)
        }
    }

    val isDebug = true
}