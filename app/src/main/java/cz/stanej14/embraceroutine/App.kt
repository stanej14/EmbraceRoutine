package cz.stanej14.embraceroutine

import android.app.Activity
import android.app.Application
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager
import com.facebook.stetho.Stetho
import cz.stanej14.embraceroutine.db.DbSettings
import cz.stanej14.embraceroutine.di.DaggerAppComponent
import cz.stanej14.embraceroutine.di.Injectable
import dagger.android.AndroidInjection
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector
import timber.log.Timber
import javax.inject.Inject


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appContext(this)
                .dbSettings(DbSettings("embrace_routine.db"))
                .build()
                .inject(this)

        registerActivityLifecycleCallbacks(CustomActivityLifecycleCallbacks())

        Timber.plant(Timber.DebugTree())

        Stetho.initializeWithDefaults(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity> {
        return dispatchingActivityInjector;
    }

    class CustomActivityLifecycleCallbacks : ActivityLifecycleCallbacks {
        override fun onActivityPaused(activity: Activity?) {
        }

        override fun onActivityResumed(activity: Activity?) {
        }

        override fun onActivityStarted(activity: Activity?) {
        }

        override fun onActivityDestroyed(activity: Activity?) {
        }

        override fun onActivitySaveInstanceState(activity: Activity?, outState: Bundle?) {
        }

        override fun onActivityStopped(activity: Activity?) {
        }

        override fun onActivityCreated(activity: Activity?, savedInstanceState: Bundle?) {
            activity?.let { handleActivity(it) }
        }

        private fun handleActivity(activity: Activity) {
            if (activity is HasSupportFragmentInjector) {
                AndroidInjection.inject(activity)
            }
            if (activity is FragmentActivity) {
                activity.supportFragmentManager
                        .registerFragmentLifecycleCallbacks(
                                object : FragmentManager.FragmentLifecycleCallbacks() {
                                    override fun onFragmentCreated(fm: FragmentManager?, f: Fragment?,
                                                                   savedInstanceState: Bundle?) {
                                        if (f is Injectable) {
                                            AndroidSupportInjection.inject(f)
                                        }
                                    }
                                }, true)
            }
        }
    }
}