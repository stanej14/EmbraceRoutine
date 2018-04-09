package cz.stanej14.embraceroutine.db

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import android.arch.persistence.room.TypeConverters
import cz.stanej14.embraceroutine.model.Routine

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {21/06/17}
 **/
@Database(entities = arrayOf(Routine::class), version = 1)
abstract class RoutineDatabase : RoomDatabase() {
    abstract fun routineDao(): RoutineDao
}