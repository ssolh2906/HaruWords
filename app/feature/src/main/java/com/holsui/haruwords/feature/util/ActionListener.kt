package com.holsui.haruwords.feature.util

interface ActionListener {

    fun onClick(action: Action)
    fun onLongPress(action: Action)
    fun onDismiss(action: Action)
}
