package cz.stanej14.embraceroutine.ui.creation

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import cz.stanej14.embraceroutine.db.RoutineDao
import cz.stanej14.embraceroutine.model.Routine
import io.reactivex.Flowable
import io.reactivex.Observable
import io.reactivex.Scheduler
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {26/06/17}
 **/
class CreateRoutineViewModel @Inject constructor() : ViewModel() {

    @Inject
    internal lateinit var routineDao: RoutineDao

    @Inject @field:Named("database")
    internal lateinit var databaseScheduler: Scheduler

    val routine: Routine = Routine()

    fun createRoutine() {
        Observable.just(routine)
                .subscribeOn(databaseScheduler)
                .map(routineDao::insert)
                .doOnError(Timber::e)
                .subscribe({ Timber.i("Routine " + it.toString() + " was created.") })
    }

    fun observe(arguments: Bundle?): Flowable<Routine> {
        if (arguments != null) {
            routineDao.get(arguments.getLong(CreateRoutineFragment.ROUTINE_ID_KEY))
        }
        return Flowable.just(routine)
    }
}