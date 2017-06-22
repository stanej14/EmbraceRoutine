package cz.stanej14.embraceroutine.di

import android.app.Application
import android.content.Context
import cz.stanej14.embraceroutine.App
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
@Module(includes = arrayOf(ViewModelModule::class))
class AppModule(val app: App) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app
}