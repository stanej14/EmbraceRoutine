package cz.stanej14.embraceroutine.ui.creation

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.di.Injectable
import cz.stanej14.embraceroutine.model.Routine
import cz.stanej14.embraceroutine.ui.common.NavigationController
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import timber.log.Timber
import javax.inject.Inject
import javax.inject.Named

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {26/06/17}
 **/
class CreateRoutineFragment : Fragment(), Injectable {

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    @Inject
    @field:Named("database")
    internal lateinit var databaseScheduler: Scheduler

    companion object {

        val ROUTINE_ID_KEY = "routine_id"

        fun createRoutine(): CreateRoutineFragment = CreateRoutineFragment()
        fun editRoutine(routineId: Long): CreateRoutineFragment {
            val createRoutineFragment = CreateRoutineFragment()
            val bundle = Bundle()
            bundle.putLong(ROUTINE_ID_KEY, routineId)
            createRoutineFragment.arguments = bundle
            return createRoutineFragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_create_routine, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateRoutineViewModel::class.java)

        view.findViewById<View>(R.id.btn_create_routine).setOnClickListener {
            viewModel.createRoutine()
            navigationController.navigateToOverview()
        }

        viewModel.observe(arguments)
                .subscribeOn(databaseScheduler)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ showData(it, view) }, Timber::e)

        val editTitle = view.findViewById<EditText>(R.id.edit_create_routine_title)
        val editGoal = view.findViewById<EditText>(R.id.edit_create_routine_goal)
        editTitle.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.routine.name = s?.toString() ?: ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        editGoal.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.routine.goal = s?.toString() ?: ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

    }

    fun showData(routine: Routine, view: View) {
        val editTitle = view.findViewById<EditText>(R.id.edit_create_routine_title)
        val editGoal = view.findViewById<EditText>(R.id.edit_create_routine_goal)
        editTitle.setText(routine.name)
        editGoal.setText(routine.goal)
    }
}