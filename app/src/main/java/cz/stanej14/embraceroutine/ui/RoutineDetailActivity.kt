package cz.stanej14.embraceroutine.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.TextView
import cz.stanej14.embraceroutine.App
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.db.RoutineDao
import javax.inject.Inject

/**
 * TODO add class description
 * Created by Jan Stanek[jan.stanek@firma.seznam.cz] on {22/06/17}
 **/
class RoutineDetailActivity : AppCompatActivity() {

    lateinit var textRoutineTitle: TextView

    @Inject
    lateinit var routineDao: RoutineDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_routine_detail)
        App.routineComponent.inject(this)
        textRoutineTitle = findViewById(R.id.text_routine_detail_title) as TextView
    }

    override fun onResume() {
        super.onResume()
        val all = routineDao.getAll()
        textRoutineTitle.text = all[0].name
    }
}