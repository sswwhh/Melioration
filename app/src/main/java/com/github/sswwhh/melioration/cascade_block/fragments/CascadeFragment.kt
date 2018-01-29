package com.github.sswwhh.melioration.cascade_block.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.sswwhh.melioration.R
import com.github.sswwhh.melioration.common_block.fragments.BaseFragment

/**
 *
 */
class CascadeFragment : BaseFragment() {

    override val LAYOUT: Int = R.layout.fragment_cascade

    companion object {
        fun newInstance() = CascadeFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        if (rootView == null) {
            setHasOptionsMenu(true)
            rootView = inflater!!.inflate(LAYOUT, container, false)
        }
        return rootView
    }

    override fun setupUI() {
        setupChatsRecyclerView()
    }

    override fun bindUX() {
    }

    override fun unbindUX() {
    }

    private fun setupChatsRecyclerView() {
    }


}