package com.holsui.haruwords.data.repository

import com.holsui.haruwords.data.database.dao.WordDao
import com.holsui.haruwords.data.models.WordEntity
import com.holsui.haruwords.data.models.asEntity
import com.holsui.haruwords.data.models.asExternalModel
import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(
    private val wordDao: WordDao
) : WordRepository {

    override fun getAllWords(): Flow<List<Word>> {
        return wordDao.getAll().map { it.map(WordEntity::asExternalModel) }
    }

    override fun addWord(word: Word) {
        wordDao.insertWords(word.asEntity())
    }

    override fun deleteWord(word: Word) {
        wordDao.deleteWords(word.asEntity())
    }
}