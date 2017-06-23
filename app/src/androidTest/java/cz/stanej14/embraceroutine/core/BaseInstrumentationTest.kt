package cz.stanej14.embraceroutine.core

import cz.stanej14.embraceroutine.App
import cz.stanej14.embraceroutine.db.RoutineDatabase
import cz.stanej14.embraceroutine.di.DatabaseModule

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
abstract class BaseInstrumentationTest {

    var testComponent: TestComponent = DaggerTestComponent.builder()
            .appModule(AppModule(App.instance))
            .databaseModule(DatabaseModule(App.instance, "test.db"))
            .build()

    fun clearDatabase(db: RoutineDatabase) {
        with(db) {
            beginTransaction()
            routineDao().removeAll(routineDao().getAll())
            endTransaction()
        }
    }
}