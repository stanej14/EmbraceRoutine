package cz.stanej14.embraceroutine.ui.overview

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.stanej14.embraceroutine.R
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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_routine_overview, container, true)
    }

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }
}