package com.vb.coroutinesDaggerRoomRetrofitTest.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.vb.coroutinesDaggerRoomRetrofitTest.data.database.model.GameData

@Dao
interface DataDao {

    @Query("SELECT * FROM GameData")
    suspend fun getAllData(): MutableList<GameData>

    @Insert
    suspend fun insertGame(gameData: GameData)
}