package com.earl.bonusmoney.data.models

import com.earl.bonusmoney.data.mappers.LoyaltyLevelDataToDomainMapper

interface LoyaltyLevelData {

    fun <T> mapToDomain(mapper: LoyaltyLevelDataToDomainMapper<T>) : T

    class Base(
        private val number: Int,
        private val name: String,
        private val requiredSum: Int,
        private val markToCash: Int,
        private val cashToMark: Int
    ) : LoyaltyLevelData {
        override fun <T> mapToDomain(mapper: LoyaltyLevelDataToDomainMapper<T>) =
            mapper.map(number, name, requiredSum, markToCash, cashToMark)
    }
}