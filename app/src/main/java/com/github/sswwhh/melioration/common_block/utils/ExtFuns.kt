package com.github.sswwhh.melioration.common_block.utils

import android.view.View
import java.util.*

/**
 * Функции расширения
 */


/**
 * Для работы с View
 */
fun View.hide() {
    visibility = View.INVISIBLE
}

fun View.gone() {
    visibility = View.GONE
}

fun View.show() {
    visibility = View.VISIBLE
}


/**
 * Работа со строками
 */
fun String.getRandomUUID(): String = UUID.randomUUID().toString()