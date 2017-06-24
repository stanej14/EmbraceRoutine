package cz.stanej14.embraceroutine.db

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {23/06/17}
 **/
class DbSettings(val name: String) {

    val dbName: String = name

    fun provideName(): String = dbName
}