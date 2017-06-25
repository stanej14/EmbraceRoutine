package cz.stanej14.embraceroutine.di

import android.content.Context
import cz.stanej14.embraceroutine.App
import cz.stanej14.embraceroutine.db.DbSettings
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
        AppModule::class,
        DatabaseModule::class))
interface AppComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appContext(appContext: Context): Builder

        @BindsInstance
        fun dbSettings(dbSettings: DbSettings): Builder

        fun build(): AppComponent
    }

    fun inject(app: App)
}