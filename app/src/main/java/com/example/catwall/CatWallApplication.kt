package com.example.catwall

import android.app.Application
import android.util.Log
import com.example.catwall.logging.Logger
import dagger.hilt.android.HiltAndroidApp
import timber.log.Timber

@HiltAndroidApp
class CatWallApplication : Application(){

    override fun onCreate() {
        super.onCreate()
        initLogger()
    }

    private fun initLogger() {
        if(BuildConfig.DEBUG){
            Timber.plant(Timber.DebugTree())
        }else{
            Timber.plant(TimberLogging())
        }

    }
}

class TimberLogging : Timber.Tree() {
    override fun log(priority: Int, tag: String?, message: String, t: Throwable?) {
        if (priority == Log.VERBOSE || priority == Log.DEBUG) {
            return
        }

        Logger.log(priority, tag, message)

        if (t != null) {
            if (priority == Log.ERROR) {
                Logger.logError(t);
            } else if (priority == Log.WARN) {
                Logger.logWarning(t);
            }
        }

    }
}



