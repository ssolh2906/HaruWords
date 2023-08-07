package com.holsui.haruwords.feature.wordslist

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun WordsListRoute(
    viewModel: WordsListViewModel = hiltViewModel()
) {
    WordsListScreen()
}

@Composable
fun WordsListScreen() {
    Text("hello haru words")
}
