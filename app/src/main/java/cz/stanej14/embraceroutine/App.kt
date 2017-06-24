package cz.stanej14.embraceroutine

import android.app.Activity
import android.app.Application
import cz.stanej14.embraceroutine.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
class App : Application(), HasActivityInjector {

    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> {
        return dispatchingActivityInjector;
    }

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent.builder()
                .appContext(this)
                .build()
                .inject(this)
    }
}