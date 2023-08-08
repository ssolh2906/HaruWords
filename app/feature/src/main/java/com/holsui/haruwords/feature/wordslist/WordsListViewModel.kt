package com.holsui.haruwords.feature.wordslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.usecase.AddWordUseCase
import com.holsui.haruwords.domain.usecase.GetAllWordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class WordsListViewModel @Inject constructor(
    val addWordUseCase: AddWordUseCase,
    val getAllWordsUseCase: GetAllWordsUseCase
) : ViewModel() {

    val wordList: StateFlow<List<Word>> = getAllWordsUseCase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(),
        initialValue = emptyList()
    )
}
