package com.holsui.haruwords.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.holsui.haruwords.domain.models.WordModel

@Entity(tableName = "words")
data class WordModelEntity(
    @PrimaryKey
    @ColumnInfo(name = "primary_key")
    val id: String,

    @ColumnInfo(name = "word")
    val word: String,

    val mean: String
)

fun WordModelEntity.asExternalModel() = WordModel(
    id = id,
    word = word,
    mean = mean
)