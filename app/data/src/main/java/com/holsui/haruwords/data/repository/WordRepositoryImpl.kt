package com.holsui.haruwords.data.repository

import com.holsui.haruwords.data.database.dao.WordDao
import com.holsui.haruwords.data.models.WordEntity
import com.holsui.haruwords.data.models.asEntity
import com.holsui.haruwords.data.models.asExternalModel
import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.repository.WordRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject

class WordRepositoryImpl @Inject constructor(
    private val wordDao: WordDao,
    private val defaultDispatcher: CoroutineDispatcher = Dispatchers.Default
) : WordRepository {

    override suspend fun getAllWords(): Flow<List<Word>> {
        return wordDao.getAll().map { it.map(WordEntity::asExternalModel) }
    }

    override suspend fun addWord(word: Word) {
        withContext(defaultDispatcher) {
            wordDao.insertWords(word.asEntity())
        }
    }

    override suspend fun deleteWord(word: Word) {
        wordDao.deleteWords(word.asEntity())
    }
}
