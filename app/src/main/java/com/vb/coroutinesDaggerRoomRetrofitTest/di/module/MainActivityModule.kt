package com.vb.coroutinesDaggerRoomRetrofitTest.di.module

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import androidx.room.Room
import com.vb.coroutinesDaggerRoomRetrofitTest.data.database.DataDb
import com.vb.coroutinesDaggerRoomRetrofitTest.di.scope.SingleScreenScope
import com.vb.coroutinesDaggerRoomRetrofitTest.domain.viewmodel.MainActvityVM
import com.vb.coroutinesDaggerRoomRetrofitTest.ui.activity.MainActivity
import dagger.Module
import dagger.Provides

@Module
class MainActivityModule(private val context: Context, private val mainActivity: MainActivity) {

    @Provides
    @SingleScreenScope
    fun provideVM(actiity: MainActivity): MainActvityVM {
        return ViewModelProvider(actiity)[MainActvityVM::class.java]
    }

    @Provides
    @SingleScreenScope
    fun provideContext(): Context{
        return context
    }

    @Provides
    @SingleScreenScope
    fun provideMainActivity(): MainActivity{
        return mainActivity
    }

    @Provides
    @SingleScreenScope
    fun provideDb(context: Context): DataDb {
        return Room.databaseBuilder(context, DataDb::class.java, "games")
            .build()
    }
}