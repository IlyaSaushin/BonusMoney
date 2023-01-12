package com.earl.bonusmoney.di

import com.earl.bonusmoney.data.BaseRepository
import com.earl.bonusmoney.data.retrofit.Service
import com.earl.bonusmoney.domain.Interactor
import com.earl.bonusmoney.domain.Repository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideRepository(
        service: Service
    ) : Repository {
        return BaseRepository(
            service
        )
    }

    @Provides
    @Singleton
    fun provideInteractor(
        repository: Repository
    ) : Interactor {
        return Interactor.Base(
            repository
        )
    }
}