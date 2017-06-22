package cz.stanej14.embraceroutine.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import cz.stanej14.embraceroutine.model.Routine

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {21/06/17}
 **/
@Dao
interface RoutineDao {
    @Query("SELECT * FROM routine")
    fun getAll(): List<Routine>

    @Insert
    fun insert(routine: Routine): Long

    @Delete
    fun delete(routine: Routine)

    @Delete
    fun removeAll(list: List<Routine>)
}