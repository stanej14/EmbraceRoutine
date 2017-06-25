package cz.stanej14.embraceroutine.di

import android.arch.persistence.room.Room
import android.content.Context
import cz.stanej14.embraceroutine.db.DbSettings
import cz.stanej14.embraceroutine.db.RoutineDao
import cz.stanej14.embraceroutine.db.RoutineDatabase
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
@Module
class DatabaseModule {

    @Singleton
    @Provides
    fun provideDb(appContext: Context, dbSettings: DbSettings): RoutineDatabase {
        return Room.databaseBuilder(appContext, RoutineDatabase::class.java, dbSettings.provideName()).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: RoutineDatabase): RoutineDao = db.routineDao()
}