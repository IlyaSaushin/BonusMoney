package com.earl.bonusmoney.domain.mappers

interface CompanyIdDomainToPresentationMapper<T> {

    fun map(id: String) : T
}