package com.eufelipe.app

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

/**
 * Created by feliperosas on 1/12/18.
 */
class App : Application() {

    companion object {
        @SuppressLint("StaticFieldLeak")
        @JvmField
        var context: Context? = null

        @JvmField
        var language: String = "en"

        @JvmField
        var country: String = "US"

        @JvmStatic
        fun getGlobalContext(): Context? = context

        @JvmStatic
        fun language(): String = language

        @JvmStatic
        fun country(): String = country
    }

    override fun onCreate() {
        super.onCreate()
        App.context = applicationContext

        getGlobalContext()?.let {
            language = it.getString(R.string.language)
            country = it.getString(R.string.country)
        }

    }
}