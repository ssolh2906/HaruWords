package com.holsui.haruwords.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.holsui.haruwords.data.models.WordEntity

@Dao
interface WordDao {

    @Query("SELECT * FROM words")
    fun getAll(): List<WordEntity>

    @Insert
    fun insertWords(vararg words: WordEntity)

    @Delete
    fun deleteWords(vararg words: WordEntity)
}
