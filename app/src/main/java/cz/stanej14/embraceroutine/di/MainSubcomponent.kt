package cz.stanej14.embraceroutine.di

import cz.stanej14.embraceroutine.ui.MainActivity
import dagger.Subcomponent
import dagger.android.AndroidInjector

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
@Subcomponent(modules = arrayOf(DatabaseModule::class))
interface MainSubcomponent : AndroidInjector<MainActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<MainActivity>()
}