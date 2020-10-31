package com.vb.coroutinesDaggerRoomRetrofitTest.di.module

import com.vb.coroutinesDaggerRoomRetrofitTest.data.network.GameApi
import dagger.Module
import dagger.Provides
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
class MainModule {

    @Singleton
    @Provides
    fun provideGameApi(): GameApi {
        val builder = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("https://api.rawg.io/")
            .build()
        return builder.create(GameApi::class.java)
    }
}