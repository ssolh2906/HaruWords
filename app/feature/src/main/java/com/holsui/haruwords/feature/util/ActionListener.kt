package com.holsui.haruwords.feature.util

interface ActionListener {
    fun onClick(action: Action)
    fun onLongPress(action: Action)
    fun onDismiss(action: Action)
}

object EmptyListener : ActionListener {
    override fun onClick(action: Action) {
        /* no-op */
    }

    override fun onLongPress(action: Action) {
        /* no-op */
    }

    override fun onDismiss(action: Action) {
        /* no-op */
    }
}