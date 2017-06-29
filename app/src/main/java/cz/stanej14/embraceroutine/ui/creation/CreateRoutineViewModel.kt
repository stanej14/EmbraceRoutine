package cz.stanej14.embraceroutine.ui.creation

import android.arch.lifecycle.ViewModel
import android.os.Bundle
import cz.stanej14.embraceroutine.db.RoutineDao
import cz.stanej14.embraceroutine.model.Difficulty
import cz.stanej14.embraceroutine.model.Routine
import io.reactivex.Observable
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {26/06/17}
 **/
class CreateRoutineViewModel @Inject constructor() : ViewModel() {

    var name = ""
    var goal = ""
    var difficulty = Difficulty.EASY
    var period: Long = 0
    var createdInMillis: Long = 0

    @Inject
    lateinit var routineDao: RoutineDao

    fun loadRoutine(bundle: Bundle) {
        TODO()
    }

    fun createRoutine() {
        val routine = Routine()
        routine.name = name
        routine.goal = goal
        routine.difficulty = difficulty
        routine.createdInMillis = createdInMillis
        routine.period = period

        Observable.just(routine)
                .subscribeOn(Schedulers.io())
                .map(routineDao::insert)
                .doOnError(Timber::e)
                .subscribe({ Timber.i("Routine " + it.toString() + " was created.") })
    }
}