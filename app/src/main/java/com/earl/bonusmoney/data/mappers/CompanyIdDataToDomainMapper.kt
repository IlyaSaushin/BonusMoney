package com.earl.bonusmoney.data.mappers

interface CompanyIdDataToDomainMapper <T> {
    fun map(id: String) : T
}