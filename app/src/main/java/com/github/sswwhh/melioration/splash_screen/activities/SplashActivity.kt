package com.github.sswwhh.melioration.splash_screen.activities

import com.github.sswwhh.melioration.R
import com.github.sswwhh.melioration.cascade_block.activities.CascadeActivity
import com.github.sswwhh.melioration.common_block.activities.BaseActivity

/**
 * Начальный экран, распределяет, куда идти дальше
 */
class SplashActivity : BaseActivity() {

    override val LAYOUT: Int = R.layout.activity_splashscreen

    override fun setupUI() {
        startActivity(CascadeActivity::class.java, true)
    }

    override fun bindUX() {
    }

    override fun unbindUX() {
    }


}