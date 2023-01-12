package com.earl.bonusmoney.data.mappers

interface CompanyIdRemoteToDataMapper <T> {

    fun map(id: String) : T
}