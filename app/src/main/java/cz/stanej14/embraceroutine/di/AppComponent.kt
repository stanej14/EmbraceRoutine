package cz.stanej14.embraceroutine.di

import cz.stanej14.embraceroutine.App
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import javax.inject.Singleton

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        MainModule::class,
        DatabaseModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: App): Builder
        fun build(): AppComponent
    }

    fun inject(app: App)
}