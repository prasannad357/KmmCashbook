package com.prasanna.easycashbook.di

import CashbookSDK
import com.prasanna.easycashbook.local.Database
import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module

fun initKoin(appDeclaration: KoinAppDeclaration = {}){
    startKoin{
        appDeclaration()
        modules(platformModule(), sdkModule)
    }
}

val sdkModule = module{
    single { CashbookSDK(get()) }
}

fun initKoin() = initKoin {  }