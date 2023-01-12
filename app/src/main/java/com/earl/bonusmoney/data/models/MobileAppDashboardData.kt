package com.earl.bonusmoney.data.models

import com.earl.bonusmoney.data.mappers.MobileAppDashboardDataToDomainMapper

interface MobileAppDashboardData {

    fun <T> mapToDomain(mapper: MobileAppDashboardDataToDomainMapper<T>) : T

    class Base(
        private val companyName: String,
        private val logo: String,
        private val backgroundColor: String,
        private val mainColor: String,
        private val cardBackgroundColor: String,
        private val textColor: String,
        private val highlightTextColor: String,
        private val accentColor: String
    ) : MobileAppDashboardData {
        override fun <T> mapToDomain(mapper: MobileAppDashboardDataToDomainMapper<T>) =
            mapper.map(companyName, logo, backgroundColor, mainColor, cardBackgroundColor, textColor, highlightTextColor, accentColor)
    }
}