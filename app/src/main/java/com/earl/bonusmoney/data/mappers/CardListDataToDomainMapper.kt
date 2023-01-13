package com.earl.bonusmoney.data.mappers

import com.earl.bonusmoney.data.models.CompanyData

interface CardListDataToDomainMapper<T> {
    fun mapSuccess(list: List<CompanyData>) : T
    fun mapException(exception: Exception) : T
}