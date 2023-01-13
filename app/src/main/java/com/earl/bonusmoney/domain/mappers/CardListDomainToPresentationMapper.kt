package com.earl.bonusmoney.domain.mappers

import com.earl.bonusmoney.domain.models.CompanyDomain

interface CardListDomainToPresentationMapper<T> {
    fun mapSuccess(list: List<CompanyDomain>) : T
    fun mapFail(exception: Exception) : T
}