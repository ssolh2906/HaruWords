package com.holsui.haruwords.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.holsui.haruwords.domain.models.Word

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey
    @ColumnInfo(name = "primary_key")
    val id: String,

    @ColumnInfo(name = "word")
    val word: String,

    val mean: String
)

fun WordEntity.asExternalModel() = Word(
    id = id,
    word = word,
    mean = mean
)