package com.holsui.haruwords.feature.wordslist

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SheetState
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.hilt.navigation.compose.hiltViewModel
import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.feature.util.Action
import com.holsui.haruwords.feature.util.ActionListener
import com.holsui.haruwords.feature.wordslist.WordListActions.OnCardClick
import com.holsui.haruwords.feature.wordslist.WordListActions.OnCardLongClick

@Composable
fun WordsListRoute(
    viewModel: WordsListViewModel = hiltViewModel()
) {
    val wordList by viewModel.wordList.collectAsState()
    val showAlert by viewModel.showAlert
    val isPopUpVisible by viewModel.isPopUpVisible

    val actionListener: ActionListener = object : ActionListener {
        override fun onClick(action: Action) {
            when (action) {
                WordListActions.OnAddClick -> {
                    viewModel.addWord()
                }

                is OnCardClick -> {

                }

                else -> {/* no-op */
                }
            }
        }

        override fun onLongPress(action: Action) {
            when (action) {
                is OnCardLongClick -> {
                    viewModel.showPopUpMenu(action.contextMenuWordId)
                }
            }
        }


    }
    WordsListScreen(wordList, actionListener, showAlert, isPopUpVisible)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WordsListScreen(
    wordList: List<Word>,
    actionListener: ActionListener,
    showAlert: Boolean = false,
    isPopUpVisible: Boolean = false,
    popUpWordId: Int? = null,
    modifier: Modifier = Modifier
) {
    val sheetState = rememberModalBottomSheetState()
    var isSheetOpen by rememberSaveable {
        mutableStateOf(false)
    }
    var isPopUpOpen by rememberSaveable {
        mutableStateOf(false)
    }

    Scaffold(floatingActionButton = {
        AddButton(
            modifier = Modifier.Companion
                .padding(24.dp),
            onClick = { isSheetOpen = true })
    }
    ) {
        if (showAlert) {
            Dialog(onDismissRequest = {}) {
                Text(text = "Duplicated Word")
            }
        }
        if (isPopUpOpen) {
            Dialog(onDismissRequest = { isPopUpOpen = false }) {
                Surface {
                    Column {
                        Text(text = "pop up for id:" + popUpWordId)
                    }
                }
            }
        }
        Box(
            modifier = modifier
                .fillMaxSize()
                .padding(it)
        ) {
            WordList(wordList, actionListener)

            if (isSheetOpen) {
                NewWordBottomSheet(
                    modifier = Modifier,
                    sheetState = sheetState,
                    onDismissRequest = { isSheetOpen = false },
                    onAddClick = { actionListener.onClick(WordListActions.OnAddClick) }
                )
            }
        }
    }
}

@Composable
private fun AddButton(
    modifier: Modifier,
    onClick: () -> Unit
) {
    FloatingActionButton(
        onClick = onClick,
        modifier = modifier
    ) {
        Icon(imageVector = Icons.Default.Add, contentDescription = "Add new word")
    }
}

@Composable
private fun WordList(wordList: List<Word>, actionListener: ActionListener) {
    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(4.dp),
        modifier = Modifier.padding(12.dp)
    ) {
        items(wordList) { word ->
            WordCard(
                word,
                onLongClick = { id ->
                    actionListener.onLongPress(OnCardLongClick(contextMenuWordId = id))
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun NewWordBottomSheet(
    modifier: Modifier,
    sheetState: SheetState,
    onDismissRequest: () -> Unit,
    onAddClick: () -> Unit
) {
    ModalBottomSheet(
        onDismissRequest = {
            onDismissRequest()
        },
        sheetState = sheetState
    )
    {
        Column(modifier = modifier.padding(24.dp)) {
            Button(onClick = {
                onAddClick()
            }) {
                Text(text = "ADD")
            }
        }
    }
}

@Composable
@Preview
fun PreviewWordList() {
    WordsListScreen(
        listOf(
            Word(0, "Cat", "고양이"),
            Word(1, "Dog", "강아지멍멍")
        ),
        actionListener = object : ActionListener {
            override fun onClick(action: Action) {
                /* no-op */
            }

            override fun onLongPress(action: Action) {
                /* no-op */
            }
        },
    )
}
