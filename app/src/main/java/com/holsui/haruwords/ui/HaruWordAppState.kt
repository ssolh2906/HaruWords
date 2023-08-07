package com.holsui.haruwords.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import kotlinx.coroutines.CoroutineScope


@Composable
fun rememberHaruWordAppState(
    coroutineScope: CoroutineScope = rememberCoroutineScope(),
    navController: NavHostController = rememberNavController()
): HaruWordAppState {
    return remember(
        navController,
        coroutineScope
    ) {
        HaruWordAppState(
            navController,
            coroutineScope
        )
    }
}

class HaruWordAppState(
    val navController: NavHostController,
    val coroutineScope: CoroutineScope,
) {

}