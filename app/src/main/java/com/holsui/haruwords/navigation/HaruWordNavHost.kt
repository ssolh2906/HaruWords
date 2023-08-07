package com.holsui.haruwords.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import com.holsui.haruwords.feature.navigation.WORDS_LIST_ROUTE
import com.holsui.haruwords.feature.navigation.wordsListScreen
import com.holsui.haruwords.ui.HaruWordAppState

@Composable
fun HaruWordNavHost(
    appState: HaruWordAppState,
    modifier: Modifier = Modifier,
    startDestination: String = WORDS_LIST_ROUTE
) {
    val navController = appState.navController
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        wordsListScreen()
    }
}