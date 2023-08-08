package com.holsui.haruwords.feature.wordslist

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.holsui.haruwords.domain.models.Word

@Composable
fun WordsListRoute(
    viewModel: WordsListViewModel = hiltViewModel()
) {
    val wordList by viewModel.wordList.collectAsState()
    WordsListScreen(wordList)
}

@Composable
fun WordsListScreen(
    wordList: List<Word>
) {
    LazyColumn(verticalArrangement = Arrangement.spacedBy(4.dp)) {
        items(wordList) { word ->
            Box(
                modifier = Modifier.fillMaxWidth()
                    .height(100.dp)
                    .background(Color.White)
                    .padding(12.dp),
                contentAlignment = Alignment.Center
            ) {
                Column {
                    Text(text = word.word)
                    Text(text = word.mean)
                }
            }
        }
    }
}

@Composable
@Preview
fun PreviewWordList() {
    WordsListScreen(
        listOf(
            Word("0", "Cat", "고양이"),
            Word("1", "Dog", "강아지")
        )
    )
}
