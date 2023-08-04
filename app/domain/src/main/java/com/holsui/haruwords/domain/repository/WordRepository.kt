package com.holsui.haruwords.domain.repository

import com.holsui.haruwords.domain.models.Word
import kotlinx.coroutines.flow.Flow

interface WordRepository {

    fun getAllWords(): Flow<List<Word>>

    fun addWord(word: Word)

    fun deleteWord(id: String)
}
