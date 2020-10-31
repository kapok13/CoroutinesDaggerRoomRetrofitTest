package com.vb.coroutinesDaggerRoomRetrofitTest.di.component

import com.vb.coroutinesDaggerRoomRetrofitTest.application.App
import com.vb.coroutinesDaggerRoomRetrofitTest.di.module.MainModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [MainModule::class])
interface MainComponent {
    fun appScopeInjection(app: App)
}