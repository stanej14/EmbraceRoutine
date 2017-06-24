package cz.stanej14.embraceroutine.di

import cz.stanej14.embraceroutine.db.DbSettings
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
@Module
class DatabaseSettingsModule {
    @Provides
    @Singleton
    fun provideDbSettings(): DbSettings {
        return DbSettings("embrace_routine.db")
    }
}