package com.holsui.haruwords.feature.wordslist

import androidx.lifecycle.ViewModel
import com.holsui.haruwords.domain.usecase.AddWordUseCase
import com.holsui.haruwords.domain.usecase.GetAllWordsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel

@HiltViewModel
class WordsListViewModel(
    val addWordUseCase: AddWordUseCase,
    val getAllWordsUseCase: GetAllWordsUseCase
) : ViewModel() {
}
