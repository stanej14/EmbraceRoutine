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
    fun saveAndLoadAllRoutines() {
        val routineDao = db.routineDao()
        val size = 10
        for (i in 1..size) routineDao.insert(generateRoutine())
        val list = routineDao.getAll().blockingFirst()
        assertTrue(list.size == size)
    }

    @Test
    fun saveAndLoadRoutine() {
        val routine = generateRoutine()
        val routineDao = db.routineDao()
        val id = routineDao.insert(routine)
        routine.id = id
        val savedRoutine = routineDao.get(id).blockingFirst()
        assertTrue(savedRoutine == routine)
    }

    fun generateRoutine(): Routine {
        val routine = Routine()
        with(routine) {
            name = "Name"
            goal = "Goal"
            difficulty = Difficulty.HARD
        }
        return routine
    }
}