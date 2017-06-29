package cz.stanej14.embraceroutine.db

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import cz.stanej14.embraceroutine.model.Routine
import io.reactivex.Flowable

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {21/06/17}
 **/
@Dao
interface RoutineDao {
    @Query("SELECT * FROM routine")
    fun getAll(): Flowable<List<Routine>>

    @Query("SELECT * FROM routine WHERE id = :arg0")
    fun get(routineId: Long): Flowable<Routine>

    @Insert
    fun insert(routine: Routine): Long

    @Delete
    fun delete(routine: Routine)

    @Delete
    fun removeAll(list: List<Routine>)
}