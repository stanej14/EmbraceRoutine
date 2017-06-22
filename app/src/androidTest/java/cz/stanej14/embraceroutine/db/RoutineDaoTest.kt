package cz.stanej14.embraceroutine.db

import cz.stanej14.embraceroutine.core.BaseInstrumentationTest
import cz.stanej14.embraceroutine.model.Difficulty
import cz.stanej14.embraceroutine.model.Routine
import junit.framework.Assert.assertTrue
import org.junit.Before
import org.junit.Test
import javax.inject.Inject

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
class RoutineDaoTest : BaseInstrumentationTest() {

    init {
        testComponent.inject(this)
    }

    @Inject
    lateinit var db: RoutineDatabase

    @Before
    fun setUp() {
        clearDatabase(db)
    }

    @Test
    fun saveAndLoadRoutine() {
        val routine = Routine()
        routine.name = "Name"
        routine.goal = "Goal"
        routine.difficulty = Difficulty.HARD
        val routineDao = db.routineDao()
        routineDao.insert(routine)
        assertTrue(routineDao.getAll().first() == routine)
    }
}