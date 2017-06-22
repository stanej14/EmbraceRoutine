package cz.stanej14.embraceroutine.di

import cz.stanej14.embraceroutine.ui.RoutineDetailActivity
import dagger.Component
import javax.inject.Singleton

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
@Singleton
@Component(modules = arrayOf(AppModule::class, DatabaseModule::class))
interface RoutineComponent {

    fun inject(routineDetailFragment: RoutineDetailActivity)

}