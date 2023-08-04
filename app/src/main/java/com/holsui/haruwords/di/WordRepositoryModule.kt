package com.holsui.haruwords.di

import com.holsui.haruwords.data.repository.WordRepositoryImpl
import com.holsui.haruwords.domain.repository.WordRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class WordRepositoryModule {

    @Binds
    abstract fun bindsWordRepository(
        wordRepository: WordRepositoryImpl
    ): WordRepository
}
