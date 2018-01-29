package com.github.sswwhh.melioration.cascade_block.activities

import android.support.v4.app.Fragment
import android.view.MenuItem
import com.github.sswwhh.melioration.R
import com.github.sswwhh.melioration.cascade_block.fragments.CascadeFragment
import com.github.sswwhh.melioration.common_block.activities.BaseActivity
import com.github.sswwhh.melioration.common_block.activities.BaseSingleActivity
import com.github.sswwhh.melioration.common_block.utils.Navigator

/**
 *
 */
class CascadeActivity : BaseActivity() {

    override val LAYOUT: Int = R.layout.activity_container
//    override val ACTIVITY_TITLE: Int = R.string.cascade_name
//    override val isToolbarBack: Boolean = true

    override fun setupUI() {
        startFragment(CascadeFragment.newInstance(), true)
    }

    override fun bindUX() {
    }

    override fun unbindUX() {
    }

    fun startFragment(fragment: Fragment, addTobackStack: Boolean){
        Navigator.startFragment(supportFragmentManager, fragment, R.id.fl_container, addTobackStack)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        onBackPressed()
        return super.onOptionsItemSelected(item)
    }


}