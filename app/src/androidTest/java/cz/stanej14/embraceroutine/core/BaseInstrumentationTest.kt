package cz.stanej14.embraceroutine.core

import android.support.test.InstrumentationRegistry
import cz.stanej14.embraceroutine.db.DbSettings
import cz.stanej14.embraceroutine.db.RoutineDatabase

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
abstract class BaseInstrumentationTest {

    var testComponent: TestComponent =
            DaggerTestComponent.builder()
                    .appContext(InstrumentationRegistry.getTargetContext())
                    .dbSettings(DbSettings("test.db"))
                    .build()

    fun clearDatabase(db: RoutineDatabase) {
        with(db) {
            try {
                val list = routineDao().getAll().blockingFirst()
                routineDao().removeAll(list)
            } catch (e: Exception) {
            }
        }
    }
}