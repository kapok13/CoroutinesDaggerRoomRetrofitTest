package com.vb.coroutinesDaggerRoomRetrofitTest.domain.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.vb.coroutinesDaggerRoomRetrofitTest.data.database.DataDb
import com.vb.coroutinesDaggerRoomRetrofitTest.data.database.model.GameData

class MainActvityVM : ViewModel() {

    fun getDataFromDb(dataDb: DataDb): LiveData<MutableList<GameData>> {
        return liveData {
            try {
                emit(dataDb.getDataDao().getAllData())
            } catch (e: Exception) {
                e.printStackTrace()
            }
        }
    }

}