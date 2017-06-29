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
import cz.stanej14.embraceroutine.ui.common.NavigationController
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
        val editTitle = view.findViewById(R.id.edit_create_routine_title) as EditText
        val editGoal = view.findViewById(R.id.edit_create_routine_goal) as EditText
        val difficultyRadioGroup = view.findViewById(R.id.radiogroup_create_routine) as RadioGroup

        editTitle.setText(viewModel.name)
        editTitle.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.name = s?.toString() ?: ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        editGoal.setText(viewModel.goal)
        editGoal.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {
                viewModel.goal = s?.toString() ?: ""
            }

            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }
        })

        difficultyRadioGroup.check(idResourceForDifficulty(viewModel.difficulty))
        difficultyRadioGroup.setOnCheckedChangeListener({ _, checkedId -> viewModel.difficulty = difficultyForIdResource(checkedId) })
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