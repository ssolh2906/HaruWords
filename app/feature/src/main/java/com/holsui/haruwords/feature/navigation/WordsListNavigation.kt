package com.holsui.haruwords.feature.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import com.holsui.haruwords.feature.wordslist.WordsListRoute

const val WORDS_LIST_ROUTE = "words_list_route"

fun NavController.navigateToWordsList(navOptions: NavOptions? = null ) {
    navigate(WORDS_LIST_ROUTE, navOptions)
}

fun NavGraphBuilder.wordsListScreen() {
    composable(route = WORDS_LIST_ROUTE) {
        WordsListRoute()
    }
}