package com.vb.coroutinesDaggerRoomRetrofitTest.data.network.model

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class GameResponce(
    @SerializedName("count")
    @Expose
    var count: Int
)