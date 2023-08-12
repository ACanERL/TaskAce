package com.example.coinace.di

import android.content.Context
import androidx.room.Room
import com.example.coinace.data.local.CoinDao
import com.example.coinace.data.local.CoinDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context): CoinDatabase =
        Room.databaseBuilder(context,CoinDatabase::class.java,"coinDatabase")
            .fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDao(database:CoinDatabase): CoinDao {
        return database.getCoinDao()
    }
}