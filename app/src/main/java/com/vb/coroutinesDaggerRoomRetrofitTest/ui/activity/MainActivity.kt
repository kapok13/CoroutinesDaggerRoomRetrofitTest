package com.vb.coroutinesDaggerRoomRetrofitTest.ui.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import com.google.android.gms.common.GooglePlayServicesNotAvailableException
import com.google.android.gms.security.ProviderInstaller
import com.vb.coroutinesDaggerRoomRetrofitTest.R
import com.vb.coroutinesDaggerRoomRetrofitTest.application.App
import com.vb.coroutinesDaggerRoomRetrofitTest.data.database.DataDb
import com.vb.coroutinesDaggerRoomRetrofitTest.data.database.model.GameData
import com.vb.coroutinesDaggerRoomRetrofitTest.domain.viewmodel.MainActvityVM
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var mainActiviVM: MainActvityVM

    @Inject
    lateinit var dataDb: DataDb

    private lateinit var dbDataList: MutableList<GameData>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        App.iniMainActivityComponent(this, this)
            ?.mainActivityInject(this)
        try {
            ProviderInstaller.installIfNeeded(this)
        } catch (e: GooglePlayServicesNotAvailableException) {
            e.printStackTrace()
        }
        getGamesFromNetwork()
        mainActiviVM.getDataFromDb(dataDb).observe(this, Observer {
            dbDataList = it
            Toast.makeText(this, "${dbDataList.size}", Toast.LENGTH_LONG).show()
        })
    }

    private fun getGamesFromNetwork() {
        CoroutineScope(Dispatchers.IO).launch {
            val responce = App.gamesApi.getGames()
            dataDb.getDataDao().insertGame(GameData(responce.count.toString()))
            withContext(Dispatchers.Main) {
                main_tv.text = responce.count.toString()
            }
        }
    }
}