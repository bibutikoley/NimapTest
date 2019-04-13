package dev.bibuti.nimaptest

import android.app.Application

import dev.bibuti.easydb.EasyDB

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        EasyDB.init(this)
    }
}
