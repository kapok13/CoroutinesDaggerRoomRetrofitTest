package com.vb.coroutinesDaggerRoomRetrofitTest.application

import android.app.Application
import android.content.Context
import com.vb.coroutinesDaggerRoomRetrofitTest.data.network.GameApi
import com.vb.coroutinesDaggerRoomRetrofitTest.di.component.DaggerMainActivityComponent
import com.vb.coroutinesDaggerRoomRetrofitTest.di.component.DaggerMainComponent
import com.vb.coroutinesDaggerRoomRetrofitTest.di.component.MainActivityComponent
import com.vb.coroutinesDaggerRoomRetrofitTest.di.module.MainActivityModule
import com.vb.coroutinesDaggerRoomRetrofitTest.di.module.MainModule
import com.vb.coroutinesDaggerRoomRetrofitTest.ui.activity.MainActivity
import javax.inject.Inject

class App : Application() {

    @Inject
    lateinit var gameApi: GameApi

    companion object InstanceProvider {

        lateinit var gamesApi: GameApi

        private var mainActivityComp: MainActivityComponent? = null

        fun iniMainActivityComponent(
            context: Context,
            mainActivity: MainActivity
        ): MainActivityComponent? {
            return if (mainActivityComp == null) {
                mainActivityComp = DaggerMainActivityComponent.builder()
                    .mainActivityModule(MainActivityModule(context, mainActivity))
                    .build()
                mainActivityComp
            } else {
                mainActivityComp
            }
        }

        fun clearComponentInstance() {
            mainActivityComp = null
        }
    }

    override fun onCreate() {
        super.onCreate()
        DaggerMainComponent.builder()
            .mainModule(MainModule())
            .build()
            .appScopeInjection(this)
        gamesApi = gameApi
    }
}