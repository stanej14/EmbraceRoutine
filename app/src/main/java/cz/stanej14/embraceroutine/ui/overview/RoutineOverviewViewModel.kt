package cz.stanej14.embraceroutine.ui.overview

import android.arch.lifecycle.ViewModel
import cz.stanej14.embraceroutine.db.RoutineDao
import cz.stanej14.embraceroutine.model.Routine
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
class RoutineOverviewViewModel @Inject constructor() : ViewModel() {

    @Inject
    lateinit var routineDao: RoutineDao

    override fun onCleared() {
        super.onCleared()
    }

    fun observe(): Flowable<List<Routine>> {
        return routineDao.getAll()
    }
}