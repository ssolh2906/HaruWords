package com.holsui.haruwords.feature.wordslist

import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.feature.util.Action

interface WordListActions : Action {
    class OnAddClick(val word: String, val meaning: String) : WordListActions
    class OnCardClick(val word: Word) : WordListActions
    class OnCardLongClick(val contextMenuWordId: Int) : WordListActions
    object OnDismissMenu : WordListActions
}
