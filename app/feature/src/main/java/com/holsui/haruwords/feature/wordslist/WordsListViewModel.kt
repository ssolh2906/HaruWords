package com.holsui.haruwords.feature.wordslist

import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.usecase.AddWordUseCase
import com.holsui.haruwords.domain.usecase.DeleteWordUseCase
import com.holsui.haruwords.domain.usecase.GetAllWordsUseCase
import com.holsui.haruwords.feature.state.MenuDialogState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsListViewModel @Inject constructor(
    private val addWordUseCase: AddWordUseCase,
    private val deleteWordUseCase: DeleteWordUseCase,
    private val getAllWordsUseCase: GetAllWordsUseCase,
) : ViewModel() {


    private val _showAlert = mutableStateOf(false)
    val showAlert: MutableState<Boolean> get() = _showAlert

    private val _menuDialogState = MutableStateFlow(MenuDialogState())
    val menuDialogState = _menuDialogState.asStateFlow()

    val wordList: StateFlow<List<Word>> = getAllWordsUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun addWord(word: String, meaning: String) {
        viewModelScope.launch {
            val result = runCatching {
                addWordUseCase.invoke(
                    Word(
                        word = word, mean = meaning
                    )
                )
            }
            result.onSuccess {
                // TODO: hoist add word dialog state, close dialog here
            }
            result.onFailure {
                _showAlert.value = true
            }
        }
    }

    fun deleteWord() {
        viewModelScope.launch {
            val result = runCatching {
                menuDialogState.value.contextMenuWordId
                    ?.let { deleteWordUseCase.invoke(it) }
            }
            result.onSuccess {
                // TODO:  
            }
            result.onFailure {
                // TODO:  
            }
        }
    }

    fun showPopUpMenu(id: Int) {
        _menuDialogState.update {
            it.copy(
                visible = true,
                contextMenuWordId = id
            )
        }
    }

    fun onDismissMenu() {
        _menuDialogState.update {
            it.copy(visible = false)
        }
    }
}
