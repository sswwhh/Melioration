package com.github.sswwhh.melioration

import android.app.Application

/**
 * Общий код и другие штуки
 *  - инициализация Даггера
 *  - инициализация Crashlytics
 *  - потом - MultiDEX
 */
class App : Application() {


    override fun onCreate() {
        super.onCreate()

        setupDagger2()
    }


    private fun setupDagger2() {

    }

}