package com.vb.coroutinesDaggerRoomRetrofitTest.data.network

import com.vb.coroutinesDaggerRoomRetrofitTest.data.network.model.GameResponce
import retrofit2.http.GET

interface GameApi {

    @GET("api/games")
    suspend fun getGames(): GameResponce
}