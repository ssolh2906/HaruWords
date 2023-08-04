package com.holsui.haruwords.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.holsui.haruwords.data.database.dao.WordDao
import com.holsui.haruwords.data.models.WordEntity

@Database(
    entities = [
        WordEntity::class
    ],
    version = 1,
)
abstract class HaruDatabase : RoomDatabase() {
    abstract fun wordDao(): WordDao
}
