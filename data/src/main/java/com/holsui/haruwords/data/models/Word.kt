package com.holsui.haruwords.data.models

import com.holsui.haruwords.domain.models.Word

fun Word.asEntity() = WordEntity(
    id = id ?: 0, word = word, mean = mean
)
