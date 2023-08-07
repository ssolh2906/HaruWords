package com.holsui.haruwords.domain.usecase

import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.repository.WordRepository

class AddWordUseCase(private val wordRepository: WordRepository) {

    operator fun invoke(word: Word) {
        wordRepository.addWord(word)
    }
}
