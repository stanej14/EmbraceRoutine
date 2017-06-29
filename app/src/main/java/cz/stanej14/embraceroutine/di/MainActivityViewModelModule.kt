package cz.stanej14.embraceroutine.di

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import cz.stanej14.embraceroutine.ui.common.CustomViewModelFactory
import cz.stanej14.embraceroutine.ui.creation.CreateRoutineViewModel
import cz.stanej14.embraceroutine.ui.creation.RoutineDetailViewModel
import cz.stanej14.embraceroutine.ui.overview.RoutineOverviewViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {26/06/17}
 **/
@Module
abstract class MainActivityViewModelModule {

    @Binds
    @IntoMap
    @ViewModelKey(RoutineOverviewViewModel::class)
    abstract fun bindRoutineOverviewModel(viewModel: RoutineOverviewViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(CreateRoutineViewModel::class)
    abstract fun bindCreateRoutineViewModel(viewModel: CreateRoutineViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(RoutineDetailViewModel::class)
    abstract fun bindRoutineDetailViewModel(viewModel: RoutineDetailViewModel): ViewModel

    @Binds
    abstract fun bindViewModelFactory(factory: CustomViewModelFactory): ViewModelProvider.Factory
}