package com.holsui.haruwords.domain.repository

import com.holsui.haruwords.domain.models.Word

interface WordRepository {

    suspend fun getAllWords(): List<Word>

    suspend fun addWord(word: Word)

    suspend fun deleteWord(id: String)
}
