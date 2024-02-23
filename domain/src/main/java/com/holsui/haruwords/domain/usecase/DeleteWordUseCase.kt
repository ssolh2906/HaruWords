package com.holsui.haruwords.domain.usecase

import com.holsui.haruwords.domain.models.Word
import com.holsui.haruwords.domain.repository.WordRepository
import java.lang.Error
import javax.inject.Inject

class DeleteWordUseCase @Inject constructor(
    private val wordRepository: WordRepository
) {

    suspend operator fun invoke(id: Int) {
        try {
            wordRepository.deleteWordById(id)
        } catch (e: Error) {
            throw e
        }
    }
}
