package com.holsui.haruwords.feature.wordslist

import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.feature.util.Action

interface WordListActions : Action {
    object OnAddClick : WordListActions
    class OnCardClick(val word: Word) : WordListActions
    class OnCardLongClick(val contextMenuWordId: Int) : WordListActions
    object OnDismissMenu : WordListActions
}
