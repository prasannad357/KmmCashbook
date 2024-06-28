package com.prasanna.easycashbook.di

import CashbookSDK
import com.prasanna.easycashbook.local.Database
import com.prasanna.easycashbook.ui.addcashbook.AddCashbookViewModel
import com.prasanna.easycashbook.ui.cashbooklist.CashbookListViewModel
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}){
    startKoin{
        appDeclaration()
        modules(platformModule(), sdkModule, viewModelModule)
    }
}

val sdkModule = module{
    single { CashbookSDK(get()) }
}

val viewModelModule = module{
    factory { CashbookListViewModel(get()) }
    factory { AddCashbookViewModel(get()) }
}

fun initKoin() = initKoin {  }