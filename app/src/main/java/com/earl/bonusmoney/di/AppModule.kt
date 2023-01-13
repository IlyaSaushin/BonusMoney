package com.earl.bonusmoney.di

import com.earl.bonusmoney.data.BaseRepository
import com.earl.bonusmoney.data.mappers.CompanyDataToDomainMapper
import com.earl.bonusmoney.data.mappers.CompanyRemoteToDataMapper
import com.earl.bonusmoney.data.models.CompanyData
import com.earl.bonusmoney.data.retrofit.Service
import com.earl.bonusmoney.domain.Interactor
import com.earl.bonusmoney.domain.Repository
import com.earl.bonusmoney.domain.models.CompanyDomain
import com.earl.bonusmoney.presentation.models.CardListRender
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
        service: Service,
        companyRemoteToDataMapper: CompanyRemoteToDataMapper<CompanyData>,
        companyDataToDomainMapper: CompanyDataToDomainMapper<CompanyDomain>
    ) : Repository {
        return BaseRepository(
            service,
            companyRemoteToDataMapper,
            companyDataToDomainMapper
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

    @Provides
    @Singleton
    fun provideCardListRender(
    ) : CardListRender {
        return CardListRender.Base()
    }
}