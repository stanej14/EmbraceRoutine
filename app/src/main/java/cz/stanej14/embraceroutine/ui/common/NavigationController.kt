package cz.stanej14.embraceroutine.ui.common

import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.ui.MainActivity
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
                .commit()
    }
}
