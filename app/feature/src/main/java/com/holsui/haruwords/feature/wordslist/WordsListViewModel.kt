package com.holsui.haruwords.feature.wordslist

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.usecase.AddWordUseCase
import com.holsui.haruwords.domain.usecase.GetAllWordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WordsListViewModel @Inject constructor(
    private val addWordUseCase: AddWordUseCase,
    private val getAllWordsUseCase: GetAllWordsUseCase,
) : ViewModel() {


    private val _showAlert = mutableStateOf(false)
    val showAlert: MutableState<Boolean> get() = _showAlert

    val isPopUpVisible = mutableStateOf(false)

    private val _wordToShowPopUp : MutableState<Int?> = mutableStateOf(null)
    val wordToShowPopUp : MutableState<Int?> get() = _wordToShowPopUp


    val wordList: StateFlow<List<Word>> = getAllWordsUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )

    fun addWord() {
        viewModelScope.launch {
            val result = runCatching {
                addWordUseCase.invoke(
                    Word(
                        word = "고양이", mean = "cat"
                    )
                )
            }
            result.onFailure {
                _showAlert.value = true
            }
        }
    }

    fun showPopUpMenu(id:Int) {
        isPopUpVisible.value = true
        _wordToShowPopUp.value = id
    }
}
