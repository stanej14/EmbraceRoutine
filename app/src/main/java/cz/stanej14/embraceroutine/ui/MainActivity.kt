package cz.stanej14.embraceroutine.ui

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.stanej14.embraceroutine.R


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        findViewById(R.id.btn_main_temp).setOnClickListener { _ ->
            run {
                val i = Intent(this, RoutineDetailActivity::class.java)
                startActivity(i)
            }
        }
    }

    override fun onResume() {
        super.onResume()
    }
}
