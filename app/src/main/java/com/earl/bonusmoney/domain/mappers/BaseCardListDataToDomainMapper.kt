package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.data.mappers.CardListDataToDomainMapper
import com.earl.bonusmoney.data.mappers.CompanyDataToDomainMapper
import com.earl.bonusmoney.data.models.CompanyData
import com.earl.bonusmoney.domain.models.CardListDomain
import com.earl.bonusmoney.domain.models.CompanyDomain
import javax.inject.Inject

class BaseCardListDataToDomainMapper @Inject constructor(
    private val companyDataToDomainMapper: CompanyDataToDomainMapper<CompanyDomain>
) : CardListDataToDomainMapper<CardListDomain> {

    override fun mapSuccess(list: List<CompanyData>) =
        CardListDomain.Success(list.map { it.map(companyDataToDomainMapper) })

    override fun mapException(exception: Exception) =
        CardListDomain.Fail(exception)
}