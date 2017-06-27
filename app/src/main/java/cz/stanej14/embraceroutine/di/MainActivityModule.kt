package cz.stanej14.embraceroutine.di

import cz.stanej14.embraceroutine.ui.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {27/06/17}
 **/
@Module
public abstract class MainActivityModule {
    @ContributesAndroidInjector(modules = arrayOf(FragmentBuildersModule::class))
    abstract fun contributeMainActivity(): MainActivity
}