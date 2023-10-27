package com.holsui.haruwords.domain.usecase

import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.repository.WordRepository
import javax.inject.Inject

class AddWordUseCase @Inject constructor(private val wordRepository: WordRepository) {

    suspend operator fun invoke(word: Word) {
        wordRepository.addWord(word)
    }
}
