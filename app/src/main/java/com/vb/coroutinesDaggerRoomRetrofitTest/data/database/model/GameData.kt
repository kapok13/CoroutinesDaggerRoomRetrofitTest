package com.vb.coroutinesDaggerRoomRetrofitTest.data.database.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class GameData(var gameTitle: String) {

    @PrimaryKey(autoGenerate = true)
    var id: Int? = null

}