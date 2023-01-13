package com.earl.bonusmoney.di

import com.earl.bonusmoney.data.mappers.*
import com.earl.bonusmoney.data.models.*
import com.earl.bonusmoney.domain.mappers.*
import com.earl.bonusmoney.domain.models.*
import com.earl.bonusmoney.presentation.mappers.*
import com.earl.bonusmoney.presentation.models.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object MappersModule {

    @Singleton
    @Provides
    fun provideCompanyIdRemoteToDataMapper(): CompanyIdRemoteToDataMapper<CompanyIdData> {
        return BaseCompanyIdRemoteToDataMapper()
    }

    @Singleton
    @Provides
    fun provideLoyaltyLevelRemoteToDataMapper(): LoyaltyLevelRemoteToDataMapper<LoyaltyLevelData> {
        return BaseLoyaltyLeveRemoteToDataMapper()
    }

    @Singleton
    @Provides
    fun provideCustomerMarkParametersRemoteToDataMapper(
        loyaltyMapper: LoyaltyLevelRemoteToDataMapper<LoyaltyLevelData>
    ): CustomerMarkParametersRemoteToDataMapper<CustomerMarkParametersData> {
        return BaseCustomerMakeParametersRemoteToDataMapper(
            loyaltyMapper
        )
    }

    @Singleton
    @Provides
    fun provideMobileAppDashboardRemoteToDataMapper() : MobileAppDashboardRemoteToDataMapper<MobileAppDashboardData> {
        return BaseMobileAppDashboardRemoteToDataMapper()
    }

    @Singleton
    @Provides
    fun provideCompanyRemoteToDataMapper(
        companyIdMapper: CompanyIdRemoteToDataMapper<CompanyIdData>,
        customerMarkParametersRemoteToDataMapper: CustomerMarkParametersRemoteToDataMapper<CustomerMarkParametersData>,
        mobileAppDashboardRemoteToDataMapper: MobileAppDashboardRemoteToDataMapper<MobileAppDashboardData>
    ): CompanyRemoteToDataMapper<CompanyData> {
        return BaseCompanyRemoteToDataMapper(
            companyIdMapper,
            customerMarkParametersRemoteToDataMapper,
            mobileAppDashboardRemoteToDataMapper
        )
    }

    @Singleton
    @Provides
    fun provideCompanyIdDataToDomainMapper(): CompanyIdDataToDomainMapper<CompanyIdDomain> {
        return BaseCompanyIdDataToDomainMapper()
    }

    @Singleton
    @Provides
    fun provideLoyaltyLevelDataToDomainMapper(): LoyaltyLevelDataToDomainMapper<LoyaltyLevelDomain> {
        return BaseLoyaltyLevelDataToDomainMapper()
    }

    @Singleton
    @Provides
    fun provideCustomerMarkParametersDataToDomainMapper(
        loyaltyLevelDataToDomainMapper: LoyaltyLevelDataToDomainMapper<LoyaltyLevelDomain>
    ): CustomerMarkParametersDataToDomainMapper<CustomerMarkParametersDomain> {
        return BaseCustomerMarkParametersDataToDomainMapper(
            loyaltyLevelDataToDomainMapper
        )
    }

    @Singleton
    @Provides
    fun provideMobileAppDashboardDataToDomainMapper(): MobileAppDashboardDataToDomainMapper<MobileAppDashboardDomain> {
        return BaseMobileAppDashboardDataToDomainMapper()
    }

    @Singleton
    @Provides
    fun provideCompanyDataToDomainMapper(
        companyIdMapper: CompanyIdDataToDomainMapper<CompanyIdDomain>,
        customerMapper: CustomerMarkParametersDataToDomainMapper<CustomerMarkParametersDomain>,
        mobileAppMapper: MobileAppDashboardDataToDomainMapper<MobileAppDashboardDomain>
    ): CompanyDataToDomainMapper<CompanyDomain> {
        return BaseCompanyDataToDomainMapper(
            companyIdMapper,
            customerMapper,
            mobileAppMapper
        )
    }

    @Singleton
    @Provides
    fun provideCompanyIdDomainToPresentationMapper(): CompanyIdDomainToPresentationMapper<CompanyIdPresentation> {
        return BaseCompanyIdDomainToPresentationMapper()
    }

    @Singleton
    @Provides
    fun provideLoyaltyLevelDomainToPresentationMapper(): LoyaltyLevelDomainToPresentationMapper<LoyaltyLevelPresentation> {
        return BaseLoyaltyLevelDomainToPresentationMapper()
    }

    @Singleton
    @Provides
    fun provideCustomerMarkParametersDomainToPresentationMapper(
        loyaltyLevelMapper: LoyaltyLevelDomainToPresentationMapper<LoyaltyLevelPresentation>
    ): CustomerMarkParametersDomainToPresentationMapper<CustomerMarkParametersPresentation> {
        return BaseCustomerMarkParametersDomainToPresentationMapper(
            loyaltyLevelMapper
        )
    }

    @Singleton
    @Provides
    fun provideMobileAppDashboardDomainToPresentationMapper() : MobileAppDashboardDomainToPresentationMapper<MobileAppDashboardPresentation> {
        return BaseMobileAppDashboardDomainToPresentationMapper()
    }

    @Singleton
    @Provides
    fun provideCompanyDomainToPresentationMapper(
        companyIdMapper: CompanyIdDomainToPresentationMapper<CompanyIdPresentation>,
        customerMapper: CustomerMarkParametersDomainToPresentationMapper<CustomerMarkParametersPresentation>,
        mobileAppMapper: MobileAppDashboardDomainToPresentationMapper<MobileAppDashboardPresentation>
    ) : CompanyDomainToPresentationMapper<CompanyPresentation> {
        return BaseCompanyDomainToPresentationMapper(
            companyIdMapper,
            customerMapper,
            mobileAppMapper
        )
    }

    @Singleton
    @Provides
    fun provideCardListDataToDomainMapper(
        mapper: CompanyDataToDomainMapper<CompanyDomain>
    ) : CardListDataToDomainMapper<CardListDomain> {
        return BaseCardListDataToDomainMapper(
            mapper
        )
    }

    @Singleton
    @Provides
    fun provideCardListDomainToPresentationMapper(
        mapper: CompanyDomainToPresentationMapper<CompanyPresentation>
    ) : CardListDomainToPresentationMapper<CardListPresentation> {
        return BaseCardListDomainToPresentationMapper(
            mapper
        )
    }
}