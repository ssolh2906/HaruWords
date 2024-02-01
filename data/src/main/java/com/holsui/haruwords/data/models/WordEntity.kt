package com.holsui.haruwords.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.holsui.haruwords.domain.models.Word

@Entity(tableName = "words")
data class WordEntity(
    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "primary_key")
    val id: Int = 0,

    @ColumnInfo(name = "word")
    val word: String,

    val mean: String
)

fun WordEntity.asExternalModel() = Word(
    id = id,
    word = word,
    mean = mean
)