package com.github.sswwhh.melioration.common_block.utils

import android.app.Activity
import android.content.Intent
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import com.github.sswwhh.melioration.R

/**
 * Проще перемещаться по активити и фрагментам
 */
object Navigator {

    fun startActivity(applicationContext: Activity,
                      activityClass: Class<out Activity>,
                      clearBackStack: Boolean) {
        val intent = Intent(applicationContext, activityClass)
        if (clearBackStack) {
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK)
        }
        applicationContext.startActivity(intent)
        applicationContext.overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }

    fun startFragment(fm: FragmentManager,
                      fragment: Fragment, container: Int,
                      addToBackStack: Boolean) {

        if (addToBackStack) {
            fm.beginTransaction()
                .replace(container, fragment)
                .addToBackStack(fragment.javaClass.name)
                .commit()
        } else {
            fm.beginTransaction()
                .replace(container, fragment)
                .commit()
        }
    }

    fun startActivityForResult(activity: Activity, activityClass: Class<out Activity>, requestCode: Int) {
        val intent = Intent(activity, activityClass)
        activity.startActivityForResult(intent, requestCode)
        activity.overridePendingTransition(R.anim.no_animation, R.anim.no_animation)
    }

    fun startActivityForResultFromFragment(fragment: Fragment, activityClass: Class<out Activity>, requestCode: Int) {
        val intent = Intent(fragment.context, activityClass)
        fragment.startActivityForResult(intent, requestCode)
    }


}