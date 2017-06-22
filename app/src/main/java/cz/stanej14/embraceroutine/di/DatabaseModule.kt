package cz.stanej14.embraceroutine.di

import android.app.Application
import android.arch.persistence.room.Room
import cz.stanej14.embraceroutine.App
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
class DatabaseModule(val app: App, val dbName: String) {

    @Singleton
    @Provides
    fun provideDb(app: Application): RoutineDatabase {
        return Room.databaseBuilder(app, RoutineDatabase::class.java, dbName).build()
    }

    @Singleton
    @Provides
    fun provideUserDao(db: RoutineDatabase): RoutineDao = db.routineDao()
}