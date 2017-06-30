package cz.stanej14.embraceroutine.ui.common

import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.ui.MainActivity
import cz.stanej14.embraceroutine.ui.creation.CreateRoutineFragment
import cz.stanej14.embraceroutine.ui.creation.RoutineDetailFragment
import cz.stanej14.embraceroutine.ui.overview.RoutineOverviewFragment
import javax.inject.Inject

/**
 * A utility class that handles navigation in [MainActivity].
 */
class NavigationController @Inject constructor(mainActivity: MainActivity) {

    private val containerId = R.id.container
    private val fragmentManager = mainActivity.supportFragmentManager

    fun navigateToOverview() {
        val overviewFragment = RoutineOverviewFragment()
        fragmentManager.beginTransaction()
                .replace(containerId, overviewFragment)
                .addToBackStack("OverviewFragment")
                .commit()
    }

    fun navigateToCreation() {
        val routineCreateFragment = CreateRoutineFragment.createRoutine()
        fragmentManager.beginTransaction()
                .replace(containerId, routineCreateFragment)
                .addToBackStack("CreateRoutineFragment")
                .commit()
    }

    fun navigateToDetail(routineId: Long) {
        val routineDetailFragment = RoutineDetailFragment.create(routineId)
        fragmentManager.beginTransaction()
                .replace(containerId, routineDetailFragment)
                .addToBackStack("RoutineDetailFragment")
                .commit()
    }

    fun navigateBack() {
        fragmentManager.popBackStack()
    }

    fun navigateToEdit(routineId: Long) {
        val routineCreateFragment = CreateRoutineFragment.editRoutine(routineId)
        fragmentManager.beginTransaction()
                .replace(containerId, routineCreateFragment)
                .addToBackStack("CreateRoutineFragment_Edit")
                .commit()
    }
}
