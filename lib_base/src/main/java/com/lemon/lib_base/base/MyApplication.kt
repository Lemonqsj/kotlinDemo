package com.lemon.lib_base.base

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.bumptech.glide.Glide
import com.lemon.lib_base.di.allModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        setApplication(this)


        startKoin{
            androidLogger()
            androidContext(this@MyApplication)
            modules(allModule)
        }
    }

    private fun setApplication(application: Application) {
        application.registerActivityLifecycleCallbacks(object : ActivityLifecycleCallbacks {
            override fun onActivityCreated(activity: Activity, savedInstanceState: Bundle?) {
                // TODO: 2021/5/24  
            }

            override fun onActivityStarted(activity: Activity) {}

            override fun onActivityResumed(activity: Activity) {}

            override fun onActivityPaused(activity: Activity) {}

            override fun onActivityStopped(activity: Activity) {}

            override fun onActivitySaveInstanceState(activity: Activity, outState: Bundle) {}

            override fun onActivityDestroyed(activity: Activity) {
                // TODO: 2021/5/24
            }

        })
    }


    override fun onLowMemory() {
        super.onLowMemory()

        Glide.get(this).clearMemory()
    }

    override fun onTrimMemory(level: Int) {
        super.onTrimMemory(level)

        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Glide.get(this).clearMemory()
        }
        Glide.get(this).trimMemory(level)
    }

    override fun onTerminate() {
        super.onTerminate()
    }
}