package cz.stanej14.embraceroutine.db

import android.arch.persistence.room.TypeConverter
import cz.stanej14.embraceroutine.model.Difficulty


/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {21/06/17}
 **/
class Converters {
    @TypeConverter
    fun fromDifficultyKey(ordinal: Int): Difficulty {
        return Difficulty.values()[ordinal]
    }

    @TypeConverter
    fun difficultyToKey(difficulty: Difficulty): Int {
        return difficulty.ordinal
    }
}

