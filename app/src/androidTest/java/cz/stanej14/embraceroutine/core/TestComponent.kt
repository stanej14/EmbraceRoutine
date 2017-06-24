package cz.stanej14.embraceroutine.core

import android.content.Context
import cz.stanej14.embraceroutine.db.RoutineDaoTest
import cz.stanej14.embraceroutine.di.AppModule
import cz.stanej14.embraceroutine.di.DatabaseModule
import cz.stanej14.embraceroutine.di.MainModule
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
interface TestComponent {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun appContext(appContext: Context): Builder

        fun build(): TestComponent
    }

    fun inject(routineDaoTest: RoutineDaoTest)

}