package cz.stanej14.embraceroutine.di

import dagger.Module

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {27/06/17}
 **/
@Module(includes = arrayOf(
        MainActivityViewModelModule::class,
        DatabaseModule::class
))
class AppModule {

}