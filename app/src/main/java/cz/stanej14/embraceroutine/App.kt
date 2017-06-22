package cz.stanej14.embraceroutine

import android.app.Application
import cz.stanej14.embraceroutine.di.AppModule
import cz.stanej14.embraceroutine.di.DaggerRoutineComponent
import cz.stanej14.embraceroutine.di.DatabaseModule
import cz.stanej14.embraceroutine.di.RoutineComponent

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
class App : Application() {

    companion object {
        lateinit var routineComponent: RoutineComponent
        lateinit var instance: App
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        routineComponent = DaggerRoutineComponent.builder()
                .appModule(AppModule(this))
                .databaseModule(DatabaseModule(this, "embrace_routine.db"))
                .build()
    }
}