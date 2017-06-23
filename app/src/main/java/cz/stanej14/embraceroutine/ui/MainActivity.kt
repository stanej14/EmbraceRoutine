package cz.stanej14.embraceroutine.ui

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import cz.stanej14.embraceroutine.R
import cz.stanej14.embraceroutine.ui.common.NavigationController
import dagger.android.AndroidInjection
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    internal lateinit var navigationController: NavigationController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            navigationController.navigateToOverview()
        }
    }
}
