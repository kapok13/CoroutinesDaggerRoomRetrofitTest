package com.vb.coroutinesDaggerRoomRetrofitTest.di.component

import com.vb.coroutinesDaggerRoomRetrofitTest.di.module.MainActivityModule
import com.vb.coroutinesDaggerRoomRetrofitTest.di.scope.SingleScreenScope
import com.vb.coroutinesDaggerRoomRetrofitTest.ui.activity.MainActivity
import dagger.Component

@Component(modules = [MainActivityModule::class])
@SingleScreenScope
interface MainActivityComponent {
    fun mainActivityInject(mainActivity: MainActivity)
}