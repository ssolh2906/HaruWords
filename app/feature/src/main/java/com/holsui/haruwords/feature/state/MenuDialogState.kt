package com.holsui.haruwords.feature.state

import androidx.compose.runtime.Stable

@Stable
data class MenuDialogState(
    val contextMenuWordId: Int? = null,
    val visible: Boolean = false,
)
