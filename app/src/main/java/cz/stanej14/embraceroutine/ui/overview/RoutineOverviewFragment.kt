package cz.stanej14.embraceroutine.ui.overview

import android.arch.lifecycle.LifecycleFragment
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.graphics.Rect
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.di.Injectable
import cz.stanej14.embraceroutine.ui.common.NavigationController
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import timber.log.Timber
import javax.inject.Inject


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
class RoutineOverviewFragment : LifecycleFragment(), Injectable {

    @Inject
    lateinit var navigationController: NavigationController

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    lateinit var compositeDisposable: CompositeDisposable

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater?.inflate(R.layout.fragment_routine_overview, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Timber.i("onViewCreated")

        if (view == null) return
        val recycler = (view.findViewById(R.id.recycler_routine_overview)) as RecyclerView
        val routineAdapter = RoutineAdapter(object : RoutineAdapter.RoutineClickListener {
            override fun onRoutineClicked(routineId: Long) {
                navigationController.navigateToDetail(routineId)
            }
        })

        recycler.adapter = routineAdapter
        recycler.layoutManager = LinearLayoutManager(context)
        recycler.addItemDecoration(object : RecyclerView.ItemDecoration() {
            override fun getItemOffsets(outRect: Rect?, view: View?, parent: RecyclerView?, state: RecyclerView.State?) {
                outRect?.bottom = view?.resources?.getDimensionPixelOffset(R.dimen.routine_adapter_offset_bottom)
            }
        })

        val viewModel = ViewModelProviders.of(this, viewModelFactory).get(RoutineOverviewViewModel::class.java)
        compositeDisposable = CompositeDisposable()
        compositeDisposable.add(viewModel.observe()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(routineAdapter::setData, Timber::e))

        view.findViewById(R.id.btn_routine_overview_new_routine).setOnClickListener({ navigationController.navigateToCreation() })
    }

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.dispose()
        Timber.i("onDestroyView")
    }
}