package cz.stanej14.embraceroutine.ui.overview

import android.arch.lifecycle.LifecycleFragment
import android.os.Bundle
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.di.Injectable
import cz.stanej14.embraceroutine.ui.common.NavigationController
import javax.inject.Inject


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
class RoutineOverviewFragment : LifecycleFragment(), Injectable {

    @Inject
    lateinit var navigationController: NavigationController

//    @Inject
//    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_routine_overview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
//        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RoutineOverviewViewModel::class.java)
        val recycler = view?.findViewById(R.id.recycler_routine_overview) as RecyclerView
    }

    override fun onResume() {
        super.onResume()
    }
}