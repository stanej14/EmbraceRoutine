package cz.stanej14.embraceroutine.ui.creation

import android.arch.lifecycle.ViewModel
import cz.stanej14.embraceroutine.db.RoutineDao
import cz.stanej14.embraceroutine.model.Routine
import io.reactivex.Flowable
import javax.inject.Inject


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {26/06/17}
 **/
class RoutineDetailViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var routineDao: RoutineDao

    fun getRoutine(routineId: Long): Flowable<Routine> = routineDao.get(routineId)
}