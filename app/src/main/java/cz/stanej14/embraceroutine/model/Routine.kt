package cz.stanej14.embraceroutine.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {21/06/17}
 **/
@Entity(tableName = "routine")
class Routine {
    @PrimaryKey(autoGenerate = true)
    var id = 0
    var name = ""
    var goal = ""
    var difficulty = Difficulty.EASY

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Routine) return false

        if (name != other.name) return false
        if (goal != other.goal) return false
        if (difficulty != other.difficulty) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id
        result = 31 * result + name.hashCode()
        result = 31 * result + goal.hashCode()
        result = 31 * result + difficulty.hashCode()
        return result
    }


}