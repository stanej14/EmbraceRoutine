package cz.stanej14.embraceroutine.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {21/06/17}
 **/
@Entity(tableName = "routine")
class Routine : Comparable<Routine> {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var name = ""
    var goal = ""
    var difficulty = Difficulty.EASY
    var period: Long = -1
    var createdInMillis: Long = -1

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other !is Routine) return false

        if (id != other.id) return false
        if (name != other.name) return false
        if (goal != other.goal) return false
        if (difficulty != other.difficulty) return false
        if (period != other.period) return false
        if (createdInMillis != other.createdInMillis) return false

        return true
    }

    override fun hashCode(): Int {
        var result = id.hashCode()
        result = 31 * result + name.hashCode()
        result = 31 * result + goal.hashCode()
        result = 31 * result + difficulty.hashCode()
        result = 31 * result + period.hashCode()
        result = 31 * result + createdInMillis.hashCode()
        return result
    }

    override fun compareTo(other: Routine): Int {
        return name.compareTo(other.name)
    }
}