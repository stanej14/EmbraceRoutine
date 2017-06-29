package cz.stanej14.embraceroutine.di

import cz.stanej14.embraceroutine.ui.creation.CreateRoutineFragment
import cz.stanej14.embraceroutine.ui.creation.RoutineDetailFragment
import cz.stanej14.embraceroutine.ui.overview.RoutineOverviewFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {27/06/17}
 **/
@Module
public abstract class FragmentBuildersModule {
    @ContributesAndroidInjector
    abstract fun contributeRoutineOverviewFragment(): RoutineOverviewFragment

    @ContributesAndroidInjector
    abstract fun contributeCreateRoutineFragment(): CreateRoutineFragment

    @ContributesAndroidInjector
    abstract fun contributeRoutineDetailFragment(): RoutineDetailFragment
}