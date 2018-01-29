package com.github.sswwhh.melioration.common_block.activities

import android.app.Activity
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.github.sswwhh.melioration.R
import com.github.sswwhh.melioration.common_block.interfaces.NecesseryActivityFields
import com.github.sswwhh.melioration.common_block.utils.Navigator

/**
 * Базовая активити для общего наследования
 */
abstract class BaseActivity : AppCompatActivity(), NecesseryActivityFields {

    abstract val LAYOUT : Int

    abstract override fun setupUI()
    abstract override fun bindUX()
    abstract override fun unbindUX()

    override fun onCreate(savedInstanceState: Bundle?) {
        setContentView(LAYOUT)
        super.onCreate(savedInstanceState)

        setupUI()
    }

    override fun onResume() {
        bindUX()
        super.onResume()
    }

    override fun onPause() {
        unbindUX()
        super.onPause()
    }


    fun startActivity(activityClass: Class<out Activity>) {
        Navigator.startActivity(this, activityClass, false)
    }

    fun startActivity(activityClass: Class<out Activity>, clearBackStack: Boolean) {
        Navigator.startActivity(this, activityClass, clearBackStack)
    }

    fun startActivityForResult(activity: Class<out Activity>, requestCode: Int) {
        Navigator.startActivityForResult(this, activity, requestCode)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }

    override fun onBackPressed() {
        finish()
        overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }

}