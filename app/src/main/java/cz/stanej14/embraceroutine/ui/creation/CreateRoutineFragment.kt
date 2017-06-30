package cz.stanej14.embraceroutine.ui.creation

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.IdRes
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.RadioGroup
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.di.Injectable
import cz.stanej14.embraceroutine.model.Difficulty
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
class CreateRoutineFragment : LifecycleFragment(), Injectable {

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

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

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_create_routine, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(CreateRoutineViewModel::class.java)

        if (view == null) return

        view.findViewById(R.id.btn_create_routine).setOnClickListener {
            viewModel.createRoutine()
            navigationController.navigateToOverview()
        }

        viewModel.observe(arguments)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ showData(it, view) }, Timber::e)

        val editTitle = view.findViewById(R.id.edit_create_routine_title) as EditText
        val editGoal = view.findViewById(R.id.edit_create_routine_goal) as EditText
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

        val difficultyRadioGroup = view.findViewById(R.id.radiogroup_create_routine) as RadioGroup
        difficultyRadioGroup.setOnCheckedChangeListener({ _, checkedId -> viewModel.routine.difficulty = difficultyForIdResource(checkedId) })
    }

    fun showData(routine: Routine, view: View) {
        val editTitle = view.findViewById(R.id.edit_create_routine_title) as EditText
        val editGoal = view.findViewById(R.id.edit_create_routine_goal) as EditText
        editTitle.setText(routine.name)
        editGoal.setText(routine.goal)
        val difficultyRadioGroup = view.findViewById(R.id.radiogroup_create_routine) as RadioGroup
        difficultyRadioGroup.check(idResourceForDifficulty(routine.difficulty))
    }

    @IdRes
    fun idResourceForDifficulty(difficulty: Difficulty): Int {
        return when (difficulty) {
            Difficulty.EASY -> R.id.radio_create_routine_easy
            Difficulty.MEDIUM -> R.id.radio_create_routine_medium
            Difficulty.HARD -> R.id.radio_create_routine_hard
            Difficulty.SUPER_HARD -> R.id.radio_create_routine_super_hard
            else -> -1
        }
    }

    fun difficultyForIdResource(idRes: Int): Difficulty {
        return when (idRes) {
            R.id.radio_create_routine_easy -> Difficulty.EASY
            R.id.radio_create_routine_medium -> Difficulty.MEDIUM
            R.id.radio_create_routine_hard -> Difficulty.HARD
            R.id.radio_create_routine_super_hard -> Difficulty.SUPER_HARD
            else -> Difficulty.EASY
        }
    }
}