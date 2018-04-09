package cz.stanej14.embraceroutine.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {21/06/17}
 **/
@Entity(tableName = "routine")
data class Routine(
        @PrimaryKey(autoGenerate = true)
        var id: Long = 0,
        var name: String = "",
        var goal: String = "",
        var period: Long = -1,
        var createdInMillis: Long = -1
)