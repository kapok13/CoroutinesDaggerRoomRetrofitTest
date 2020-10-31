package com.vb.coroutinesDaggerRoomRetrofitTest.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.vb.coroutinesDaggerRoomRetrofitTest.data.database.model.GameData

@Database(entities = [GameData::class], version = 1, exportSchema = false)
abstract class DataDb : RoomDatabase() {
    abstract fun getDataDao(): DataDao
}