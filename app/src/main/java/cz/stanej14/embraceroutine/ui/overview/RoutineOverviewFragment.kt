package cz.stanej14.embraceroutine.ui.overview

import android.content.Context
import android.support.v4.app.Fragment
import cz.stanej14.embraceroutine.ui.common.NavigationController
import dagger.android.support.AndroidSupportInjection
import javax.inject.Inject


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
class RoutineOverviewFragment : Fragment() {

    @Inject
    internal lateinit var navigationController: NavigationController

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        AndroidSupportInjection.inject(this)
    }
}