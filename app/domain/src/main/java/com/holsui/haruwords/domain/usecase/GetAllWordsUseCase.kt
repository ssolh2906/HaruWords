package com.holsui.haruwords.domain.usecase

import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.repository.WordRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllWordsUseCase @Inject constructor(private val wordRepository: WordRepository) {

    operator fun invoke(): Flow<List<Word>> {
        return wordRepository.getAllWords()
    }
}
