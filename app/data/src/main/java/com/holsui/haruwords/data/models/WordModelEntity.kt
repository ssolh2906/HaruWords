package com.holsui.haruwords.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "words")
data class WordModelEntity(
    @PrimaryKey
    @ColumnInfo(name = "primary_key")
    val id: String,

    @ColumnInfo(name = "word")
    val word: String,

    val mean: String
)
