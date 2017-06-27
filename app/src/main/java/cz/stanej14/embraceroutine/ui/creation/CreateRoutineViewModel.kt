package cz.stanej14.embraceroutine.ui.creation

import android.arch.lifecycle.ViewModel
import cz.stanej14.embraceroutine.model.Difficulty
import javax.inject.Inject

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {26/06/17}
 **/
class CreateRoutineViewModel @Inject constructor() : ViewModel() {

    var title = ""
    var goal = ""
    var difficulty = Difficulty.EASY
    var period = 0
    var timeCreatedInMillis = 0

    fun createRoutine(): Boolean {
        return true
    }
}