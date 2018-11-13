package com.example.mvpkotlindemo

import android.app.Application
import com.facebook.drawee.backends.pipeline.Fresco

class MyApp : Application() {
    companion object {
        @JvmStatic
        lateinit var app: MyApp
            private set
    }

    override fun onCreate() {
        super.onCreate()
        app = this
        Fresco.initialize(app)
    }
}