package com.github.sswwhh.melioration.common_block.utils

import android.annotation.SuppressLint
import android.app.Activity
import android.app.ActivityManager
import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkInfo
import android.os.Build
import android.os.Handler
import android.os.Looper
import android.os.PowerManager
import android.provider.Settings
import android.support.annotation.RequiresApi
import android.util.Log
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.EditText
import java.util.*

/**
 *
 */
object AndroidUtils {

    private val CLIPBOARD_LABEL = "COPY_FROM_ASAPP"

    fun keyboardHide(activity: Activity?) {
        try {
            val imm = activity?.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(activity.currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            Log.d("AndroidUtils", "hide: Keyboard is not found")
        }

    }

    fun keyboardShow(editText: EditText) {
        Handler().postDelayed({
            editText.requestFocus()
            editText.setSelection(editText.text.length)
            val imm = editText.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.showSoftInput(editText, InputMethodManager.SHOW_IMPLICIT)
        },50)

    }

    fun keyboardToggle(view: View) {
        val imm = view.context.getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
        imm.hideSoftInputFromWindow(view.windowToken, 0)
    }


    fun clipboardCopy(context: Context, field: String) {
        val clipboard = context.getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clip = ClipData.newPlainText(CLIPBOARD_LABEL, field)
        clipboard.primaryClip = clip
    }

    fun isApplicationForeground(context: Context): Boolean {
        val appProcessInfo = ActivityManager.RunningAppProcessInfo()
        ActivityManager.getMyMemoryState(appProcessInfo)
        return appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND ||
                appProcessInfo.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_VISIBLE
    }

    fun isScreenOff(context: Context): Boolean {
        val powerManager = context.getSystemService(Context.POWER_SERVICE) as PowerManager
        return !powerManager.isScreenOn
    }

    fun getRandomUUID(): String {
        return UUID.randomUUID().toString()
    }

    fun isApplicationActive(context: Context): Boolean {
        return isApplicationForeground(context) && !isScreenOff(context)
    }

    @SuppressLint("NewApi")
    fun isNetworkAvailable(applicationConext: Context): Boolean {
        val connectivity = applicationConext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            val info = connectivity.allNetworks
            if (info != null) {
                for (i in info.indices) {
                    if (info[i] != null && connectivity.getNetworkInfo(info[i]).isConnected) {
                        return true
                    }
                }
            }
        } else {
            val info = connectivity.allNetworkInfo
            if (info != null) {
                for (i in info.indices) {
                    if (info[i].state == NetworkInfo.State.CONNECTED) {
                        return true
                    }
                }
            }
            val activeNetwork = connectivity.activeNetworkInfo
            if (activeNetwork != null && activeNetwork.isConnected) {
                return true
            }
        }

        return false
    }

    fun runOnUiThread(runnable: Runnable, delay: Long) {
        val mainHandler = Handler(Looper.getMainLooper())
        mainHandler.postDelayed(runnable, delay)
    }

    @SuppressLint("HardwareIds")
    fun getDeviceId(activity: Activity): String = Settings.Secure.getString(activity.contentResolver, Settings.Secure.ANDROID_ID)
}