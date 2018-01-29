package com.github.sswwhh.melioration.common_block.fragments

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.View

/**
 *
 */
abstract class BaseFragment : Fragment() {

    abstract val LAYOUT : Int

    abstract fun setupUI()
    abstract fun bindUX()
    abstract fun unbindUX()

    protected var rootView: View? = null
    private var isAttached: Boolean = false

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        if (!isAttached) {
            setupUI()
            isAttached = true
        }
        super.onActivityCreated(savedInstanceState)
    }

    override fun onResume() {
        bindUX()
        super.onResume()
    }

    override fun onPause() {
        unbindUX()
        super.onPause()
    }


}