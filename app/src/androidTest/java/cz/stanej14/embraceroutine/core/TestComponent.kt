package cz.stanej14.embraceroutine.core

import cz.stanej14.embraceroutine.db.RoutineDaoTest
import cz.stanej14.embraceroutine.di.AppModule
import cz.stanej14.embraceroutine.di.DatabaseModule
import dagger.Component
import javax.inject.Singleton

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
@Singleton
@Component(modules = arrayOf(AppModule::class, DatabaseModule::class))
interface TestComponent {

    fun inject(routineDaoTest: RoutineDaoTest)

}