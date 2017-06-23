package cz.stanej14.embraceroutine.di

import android.app.Activity
import cz.stanej14.embraceroutine.ui.MainActivity
import dagger.Binds
import dagger.Module
import dagger.android.ActivityKey
import dagger.android.AndroidInjector
import dagger.multibindings.IntoMap



/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
@Module(subcomponents = arrayOf(MainSubcomponent::class))
abstract class MainModule {
    @Binds
    @IntoMap
    @ActivityKey(MainActivity::class)
    internal abstract fun bindYourActivityInjectorFactory(builder: MainSubcomponent.Builder): AndroidInjector.Factory<out Activity>
}