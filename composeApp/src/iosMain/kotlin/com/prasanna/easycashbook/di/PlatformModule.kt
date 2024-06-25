package com.prasanna.easycashbook.di

import com.prasanna.easycashbook.local.DatabaseDriverFactory
import org.koin.core.module.Module
import org.koin.dsl.module

actual fun platformModule(): Module {
    return module {
        single { DatabaseDriverFactory() }
    }
}