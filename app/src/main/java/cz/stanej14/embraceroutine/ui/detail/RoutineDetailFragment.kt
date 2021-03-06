package cz.stanej14.embraceroutine.ui.creation

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.di.Injectable
import cz.stanej14.embraceroutine.model.Routine
import cz.stanej14.embraceroutine.ui.common.NavigationController
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import timber.log.Timber
import javax.inject.Inject

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {26/06/17}
 **/
class RoutineDetailFragment : Fragment(), Injectable {

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    companion object {

        val ROUTINE_ID_KEY = "routine_id"

        fun create(routineId: Long): RoutineDetailFragment {
            val fragment = RoutineDetailFragment()
            val args = Bundle()
            args.putLong(ROUTINE_ID_KEY, routineId)
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_routine_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RoutineDetailViewModel::class.java)

        // Check
        if (!arguments!!.containsKey(ROUTINE_ID_KEY)) {
            throw IllegalStateException("Id of a routine to be shown is not set!")
        }
        val routineId = arguments!!.getLong(ROUTINE_ID_KEY)

        viewModel.getRoutine(routineId)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ showData(it, viewModel, view) }, Timber::e)
    }

    private fun showData(routine: Routine, viewModel: RoutineDetailViewModel, view: View?) {
        if (view == null) return

        val textTitle = view.findViewById<TextView>(R.id.txt_item_routine_name)
        textTitle.text = routine.name

        view.findViewById<View>(R.id.btn_routine_detail_delete).setOnClickListener({ viewModel.delete(routine) })
        view.findViewById<View>(R.id.btn_routine_detail_edit).setOnClickListener({ navigationController.navigateToEdit(routine.id) })
    }
}